package net.jeeshop.services.front.lifecoin.impl;

import com.azazar.bitcoin.jsonrpcclient.Bitcoin;
import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;
import net.jeeshop.core.ServersManager;
import net.jeeshop.services.common.LifeCoinPay;
import net.jeeshop.services.front.lifecoinlog.LifeCoinLogService;
import net.jeeshop.services.front.lifecoinlog.bean.LifeCoinLog;
import net.jeeshop.services.front.lifecoin.LifeCoinService;
import net.jeeshop.services.front.lifecoin.bean.LifeCoin;
import net.jeeshop.services.front.lifecoin.dao.LifeCoinDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by Qiao on 2016/12/10.
 */
@Service("lifeCofinServiceFront")
public class LifeCofinServiceImpl extends ServersManager<LifeCoin, LifeCoinDao> implements
        LifeCoinService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LifeCofinServiceImpl.class);

    @Autowired
    private LifeCoinLogService lifeCoinLogService;

    @Autowired
    @Override
    public void setDao(LifeCoinDao lifeCoinDao) {
        this.dao = lifeCoinDao;
    }

    private BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();


    /**
     * 0失败 1成功
     * @param lifeCoin
     * @return
     */
    @Override
    public int checkUserLifeCoin(LifeCoin lifeCoin) {
        if (lifeCoin.getAccountid() == null) {
            logger.error("获取个人虚拟币,userid是空的");
            return 0;
        }else {
           LifeCoin reobj =  dao.selectOne(lifeCoin);
            //没有过虚拟币地址，发rpc获取
            if (reobj==null) {
                try {
                    //虚拟币地址
                    String lifeAddress = client.getAccountAddress("userid_" + lifeCoin.getAccountid());
                    double coinNum = client.getBalance("userid_" + lifeCoin.getAccountid());
                    reobj = new LifeCoin();
                    //没存到数据库过就存一次
                    reobj.setAccountid(lifeCoin.getAccountid());
                    reobj.setCoincount(coinNum);
                    //默认只放第一个地址
                    reobj.setCoinaddress(lifeAddress);
                    reobj.setIslock(0);
                    //第一次保存
                    dao.insert(reobj);
                    return 1;
                } catch (BitcoinException e) {
                    e.printStackTrace();
                    logger.error("rpc虚拟币客户端调用异常："+e.getLocalizedMessage());
                    return 0;
                }
            }else if(reobj.getCoinaddress() != null && reobj.getCoinaddress() != ""){
                //说明有历史记录的
                try {
                    double coinNum = client.getBalance("userid_" + lifeCoin.getAccountid());
                    reobj.setCoincount(coinNum);
                    dao.update(reobj);
                    //查一下最新账户余额
                    return 1;
                } catch (BitcoinException e) {
                    e.printStackTrace();
                    logger.error("rpc虚拟币客户端调用异常，只获取币个数："+e.getLocalizedMessage());
                    return 0;
                }
            }else{
                logger.error("账户存在问题，可能地址不存在，userid："+lifeCoin.getAccountid());
                return 0;
            }
        }
    }

    /**
     * 传入的对象必须放置了userid  此方法只做支付
     * @param lifeCoinLog
     * @return
     */
    @Override
    public LifeCoinPay doLifeCoinPay(LifeCoinLog lifeCoinLog) {
        LifeCoinPay lifeCoinPay = new LifeCoinPay();
        if (lifeCoinPay.officeAddress == null || lifeCoinPay.officeAddress == "") {
            lifeCoinPay.setPayStatus(false);
            lifeCoinPay.setMsg("地址问题，支付失败");
            logger.error("官网的虚拟币地址存在问题，支付失败！");
            return lifeCoinPay;
        }
        if (lifeCoinLog.getUserid() == null) {
            lifeCoinPay.setPayStatus(false);
            lifeCoinPay.setMsg("用户账户为空，支付失败");
            logger.error("用户账户为空，支付失败！");
            return lifeCoinPay;
        }
        if (lifeCoinLog.getNeedNum() == null) {
            lifeCoinPay.setPayStatus(false);
            lifeCoinPay.setMsg("需支付金额为空，支付失败");
            logger.error("需支付金额为空，支付失败！");
            return lifeCoinPay;
        }
        LifeCoin search = new LifeCoin();
        search.setAccountid(lifeCoinLog.getUserid());
        search = dao.selectOne(search);//获取到用户的虚拟币信息
        double coinNum = 0;
        try {
            coinNum = client.getBalance("userid_" + lifeCoinLog.getUserid());
        } catch (BitcoinException e) {
            e.printStackTrace();
            logger.error("交易前验证虚拟币出错"+e.getLocalizedMessage());
            lifeCoinPay.setPayStatus(false);
            lifeCoinPay.setMsg("交易前验证虚拟币出错，支付失败！");
            return lifeCoinPay;
        }
        if (coinNum == 0 || coinNum < lifeCoinLog.getNeedNum()) {
            lifeCoinPay.setPayStatus(false);
            lifeCoinPay.setMsg("您的虚拟钱包账户余额不足，支付失败！");
            logger.error("余额不足，支付失败");
            return lifeCoinPay;
        }else {
            //正在支付
            String orderNum;
            try {
                orderNum= client.sendFrom("userid_" + lifeCoinLog.getUserid(), lifeCoinPay.officeAddress, lifeCoinLog.getNeedNum());
            } catch (BitcoinException e) {
                e.printStackTrace();
                logger.error("虚拟币支付出错：" + e.getLocalizedMessage());
                lifeCoinPay.setPayStatus(false);
                lifeCoinPay.setMsg("支付失败，请稍候重试！");
                return lifeCoinPay;
            }
            lifeCoinPay.setPayStatus(true);
            lifeCoinPay.setMsg("支付成功");

            LifeCoinLog newlog = new LifeCoinLog();
            newlog.setUserid(lifeCoinLog.getUserid());
            newlog.setStatus(1);
            newlog.setLifecoinid(Integer.parseInt(search.getId()));
            newlog.setCreatetime(new Date());
            newlog.setOutnum(lifeCoinLog.getNeedNum());
            newlog.setFormaddress("userid_" + lifeCoinLog.getUserid());
            newlog.setToaddress(lifeCoinPay.officeAddress);
            newlog.setType(2);
            newlog.setOrdernum(orderNum);
            lifeCoinLogService.insert(newlog);
            return lifeCoinPay;
        }
    }

    @Override
    public boolean checkLock(String accId) {
        LifeCoin searchBean = new LifeCoin();
        searchBean.setAccountid(Integer.parseInt(accId));

        searchBean = dao.selectOne(searchBean);
        if (searchBean.getIslock() == null) {
            return false;
        }
        return searchBean.getIslock()==1?true:false;
    }

    @Override
    public boolean checkLastDeal(String accId) {
        try {
            /*先取出大小*/
            //int size = client.listTransactions("userid_" + accId).size();
            /*前一次交易*/
            List<Bitcoin.Transaction> list = client.listTransactions("userid_" + accId, 1,0);
            if (list == null || list.size() == 0) {
                return true;
            }
            Bitcoin.Transaction transaction = list.get(0);
            /*前一次交易不为空或者确认超过3次就可以*/
            if (transaction == null || transaction.confirmations() >= 3) {
                return true;
            }
            return false;
        } catch (BitcoinException e) {
            logger.error("获取上次交易异常："+e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}

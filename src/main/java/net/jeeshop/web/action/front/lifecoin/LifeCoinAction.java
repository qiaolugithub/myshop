package net.jeeshop.web.action.front.lifecoin;

import com.azazar.bitcoin.jsonrpcclient.Bitcoin;
import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;
import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.common.LifeCoinHisObj;
import net.jeeshop.services.front.account.AccountService;
import net.jeeshop.services.front.account.bean.Account;
import net.jeeshop.services.front.lifecoin.LifeCoinService;
import net.jeeshop.services.front.lifecoin.bean.LifeCoin;
import net.jeeshop.web.action.BaseController;
import net.jeeshop.web.util.LoginUserHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiao on 2016/9/13.
 */
@Controller("FrontLifeCoinController")
@RequestMapping("/front/lifecoin/")
public class LifeCoinAction extends BaseController<LifeCoin> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LifeCoinAction.class);
    private static final long serialVersionUID = 1L;

    private static final String toLoginRedirect = "redirect:/account/login";//转到登陆界面,getResponse().sendRedirect(arg0)方式 地址变化

    @Autowired
    private LifeCoinService lifeCoinService;

    @Autowired
    private AccountService accountService;


    public void setLifeCoinService(LifeCoinService lifeCoinService) {
        this.lifeCoinService = lifeCoinService;
    }

    @Override
    public Services<LifeCoin> getService() {
        return lifeCoinService;
    }



    private BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();


    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @RequestMapping("turnOut")
    public String toShow( Model model) {
        Account account = LoginUserHolder.getLoginAccount();
        if (account == null || StringUtils.isBlank(account.getAccount())) {
            return toLoginRedirect;
        }


        model.addAttribute("accountid", account.getId());
        if (lifeCoinService.checkLastDeal(account.getId())) {
            model.addAttribute("isCheck", true);
        }else {
            model.addAttribute("isCheck", false);
        }

       /* model.addAttribute("account", account);

        LifeCoin searchBean = new LifeCoin();
        searchBean.setId(id);
        LifeCoin lifeCoin = lifeCoinService.selectOne(searchBean);
        model.addAttribute("lifeCoin", lifeCoin);

        PagerModel pager = new PagerModel();
        try {
            List<Bitcoin.Transaction> list = client.listTransactions("userid_" +accountid, 10, 0);
            int count = client.listTransactions("userid_" + accountid).size();
            List<LifeCoinHisObj> tempList = new ArrayList<LifeCoinHisObj>();
            for (Bitcoin.Transaction transaction : list) {

                LifeCoinHisObj lifeCoinHisObj = new LifeCoinHisObj();
                lifeCoinHisObj.setAccount(transaction.account());
                lifeCoinHisObj.setAddress(transaction.address());
                lifeCoinHisObj.setCategory(transaction.category());
                lifeCoinHisObj.setAmount(transaction.amount());

                //  lifeCoinHisObj.setFee( transaction.fee() );
                lifeCoinHisObj.setConfirmations(transaction.confirmations());
                lifeCoinHisObj.setBlockHash(transaction.blockHash());
                lifeCoinHisObj.setBlockIndex(transaction.blockIndex());
                lifeCoinHisObj.setBlockTime(transaction.blockTime());
                lifeCoinHisObj.setTxId(transaction.txId());
                lifeCoinHisObj.setTime(transaction.time());
                lifeCoinHisObj.setTimeReceived(transaction.timeReceived());
                lifeCoinHisObj.setComment(transaction.comment());
                lifeCoinHisObj.setCommentTo(transaction.commentTo());
                tempList.add(lifeCoinHisObj);
            }
            pager.setTotal(count);
            pager.setPageSize(10);
            pager.setList(tempList);
        } catch (BitcoinException e) {
            e.printStackTrace();
            logger.error("跳转虚拟币页面获取历史信息异常：" + e.getLocalizedMessage());
        }
        // 计算总页数
        pager.setPagerSize((pager.getTotal() + pager.getPageSize() - 1)
                / pager.getPageSize());
        model.addAttribute("pager", pager);*/
        return "/front/lifecoin/lifecoin_turnout";
    }

    @RequestMapping("sendlifeCoin")
    public String sendlifeCoin(String address,Double num,Model model) {
        Account account = LoginUserHolder.getLoginAccount();
        if (account == null || StringUtils.isBlank(account.getAccount())) {
            return toLoginRedirect;
        }
        if (address == null) {
            throw new NullPointerException("地址不存在！");
        }
        if (num == null) {
            throw new NullPointerException("金额不能为空！");
        }
        if (!lifeCoinService.checkLastDeal(account.getId())) {
            model.addAttribute("msg", "您上次的一笔交易还没达到三次确认请等待三次确认后进行操作！");
            return "/front/lifecoin/lifecoin_turnout";
        }
        try {
            client.sendFrom("userid_" + account.getId(), address, num);
        } catch (BitcoinException e) {
            logger.error("转出虚拟币异常"+e.getMessage());
            e.printStackTrace();
            model.addAttribute("msg", "转出失败，请稍候重试！");
        }
        model.addAttribute("msg", "转出成功，请注意查收！");
        return "/front/lifecoin/lifecoin_turnout";
    }

    @RequestMapping("saveUserLifeCoin")
    public String saveUserLifeCoin(LifeCoin lifeCoin,String accountid) {
        if (lifeCoin.getId() == null) {
            throw new NullPointerException("id不存在！");
        }
        lifeCoinService.update(lifeCoin);
        return "redirect:/front/lifecoin/toShow?id="+lifeCoin.getId()+"&accountid="+accountid;
    }

}

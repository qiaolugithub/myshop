package net.jeeshop.web.action.manage.lifecoin;

import com.azazar.bitcoin.jsonrpcclient.Bitcoin;
import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;
import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.core.util.DownLoadUtil;
import net.jeeshop.services.common.LifeCoinHisObj;
import net.jeeshop.services.manage.account.bean.Account;
import net.jeeshop.services.manage.account.AccountService;
import net.jeeshop.services.manage.lifecoin.LifeCoinService;
import net.jeeshop.services.manage.lifecoin.bean.LifeCoin;
import net.jeeshop.web.action.BaseController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Qiao on 2016/9/13.
 */
@Controller("ManageLifeCoinController")
@RequestMapping("/manage/lifecoin/")
public class LifeCoinAction extends BaseController<LifeCoin> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LifeCoinAction.class);
    private static final long serialVersionUID = 1L;
    @Autowired
    private LifeCoinService lifeCoinService;

    @Autowired
    private AccountService accountService;


    @Override
    public Services<LifeCoin> getService() {
        return lifeCoinService;
    }



    private BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();



    private static final String page_toList = "/manage/lifecoin/lifecoinList";
    private static final String page_toAdd = "/manage/lifecoin/lifecoinEdit";
    private static final String page_toEdit = "/manage/lifecoin/lifecoinEdit";

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private LifeCoinAction(){
        super.page_toList = page_toList;
        super.page_toAdd = page_toAdd;
        super.page_toEdit = page_toEdit;
    }
    @Override
    protected void selectListAfter(PagerModel pager) {
        pager.setPagerUrl("selectList");
    }

    @Override
    public String selectList(HttpServletRequest request,@ModelAttribute("e") LifeCoin e) throws Exception {
        try {
            super.selectList(request, e);
            LifeCoin coin = lifeCoinService.getSumAndCount();
            request.setAttribute("sum",  coin.getSumNum());
            request.setAttribute("count",  coin.getCountNum());
            return page_toList;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }



    @RequestMapping("toShow")
    public String toShow(String accountid,String id, Model model) {
        if (accountid == null || accountid=="") {
            throw new NullPointerException("用户id不存在！");
        }
        if (id == null || id=="") {
            throw new NullPointerException("id不存在！");
        }
        Account account = accountService.selectById(accountid);

        model.addAttribute("accountid", accountid);

        model.addAttribute("account", account);

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
        model.addAttribute("pager", pager);
        return "/manage/lifecoin/user_lifecoinList";
    }


    @RequestMapping("saveUserLifeCoin")
    public String saveUserLifeCoin(LifeCoin lifeCoin,String accountid) {
        if (lifeCoin.getId() == null) {
            throw new NullPointerException("id不存在！");
        }
        lifeCoinService.update(lifeCoin);
        return "redirect:/manage/lifecoin/toShow?id="+lifeCoin.getId()+"&accountid="+accountid;
    }

    @RequestMapping(value = "export",method = RequestMethod.GET)
    public void exportExpresses(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String filePath = this.getClass().getResource("/").getPath();
        String filename = lifeCoinService.exportAllUserLifeCoinList();
        DownLoadUtil.downloadFile(request, response, filePath, filename);

    }

}

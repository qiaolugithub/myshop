package net.jeeshop.web.action.front.discount;

import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;
import net.jeeshop.core.Services;
import net.jeeshop.core.util.DateTimeUtil;
import net.jeeshop.services.common.LifeCoinPay;
import net.jeeshop.services.front.discountDetail.bean.DiscountDetail;
import net.jeeshop.services.front.lifecoinlog.bean.LifeCoinLog;
import net.jeeshop.services.front.account.bean.Account;
import net.jeeshop.services.front.catalog.CatalogService;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import net.jeeshop.services.front.discountDetail.DiscountDetailService;
import net.jeeshop.services.front.lifecoin.LifeCoinService;
import net.jeeshop.services.front.product.ProductService;
import net.jeeshop.web.action.BaseController;
import net.jeeshop.web.util.LoginUserHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Qiao on 2016/9/13.
 */
@Controller("FrontDicountController")
@RequestMapping("discount")
public class DiscountAction extends BaseController<Discount> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DiscountAction.class);
    private static final long serialVersionUID = 1L;
    // 登陆错误信息
    private static final String toLogin = "/account/login";//转到登陆界面,forword方式 地址不变
    @Autowired
    private DiscountService discountService;

    @Autowired
    private CatalogService catalogService;

    private BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();

    @Autowired
    private ProductService productService;

    @Autowired
    private DiscountDetailService discountDetailService;

    @Autowired
    private LifeCoinService lifeCoinService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Services<Discount> getService() {
        return null;
    }

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public void ttt(){
       /* Discount discount = new Discount();
        discount.setName("11");
        discount.setFacevale((double) 200);
        discount.setBegintime(new Date());
        discount.setEndtime(new Date());
        discount.setProtype(1);
        discount.setProid(1);
        discount.setConverttype(1);
        discount.setCuttype(1);
        discount.setCutnum((double) 100);
        discount.setCreatetime(new Date());
        discountService.insert(discount);*/
    }



    @RequestMapping(value = "getDiscount",method = RequestMethod.POST)
    @ResponseBody
    public String getDiscount(String id){
        Account acc = (Account) LoginUserHolder.getLoginAccount();
        if (acc == null || StringUtils.isBlank(acc.getAccount())) {
            return toLogin;
        }
        if (id == null || id == "") {
            return "error";
        }
        Discount discount = discountService.selectById(id);
        if (discount.getLevcount() <= 0) {
            return "lev0";
        }

        Map map = new HashMap();
        map.put("disId", id);
        map.put("account", acc.getId());
        int count = discountDetailService.getHasCount(map);

        if (count >= discount.getLimget() && discount.getLimget()!=0) {
            return "count";
        }else    {
                //领取成功就把优惠券减少
                discount.setLevcount(discount.getLevcount()-1);
                discountService.update(discount);
                //新增详细绑在用户上的
                DiscountDetail discountDetail = new DiscountDetail();
                discountDetail.setDisid(Integer.parseInt(discount.getId()));
                discountDetail.setGtime(DateTimeUtil.getCurrDate(DateTimeUtil.FORMAT_ONE));
                discountDetail.setStatus(1);//标记可用
                discountDetail.setConverttype(discount.getConverttype());
                discountDetail.setConvertnum(discount.getConvertnum());
                discountDetail.setAccountid(Integer.parseInt(acc.getId()));
                discountDetailService.insert(discountDetail);
                return "success";
        }
    }

    //跳转兑换页面
    @RequestMapping(value = "toChange",method = RequestMethod.GET)
    public String toChange(String id,HttpServletRequest request){
        Account acc = (Account) LoginUserHolder.getLoginAccount();
        if (acc == null || StringUtils.isBlank(acc.getAccount())) {
            return toLogin;
        }
        if (id == null || id == "") {
            request.setAttribute("msg", "不存在的优惠券！");
            return "/account/discountError";
        }
        Discount discount = discountService.selectById(id);
        if (discount == null) {
            request.setAttribute("msg", "无效的优惠券！");
            return "/account/discountError";
        }
        if(discount.getLevcount()<=0){
            request.setAttribute("msg", "优惠券已抢完抱歉！");
            return "/account/discountError";
        }
        String ymd = sdf.format(new Date());
        if (discount.getBegintime().compareTo(ymd) <= 0 && discount.getEndtime().compareTo(ymd) >= 0) {

        }else{
            request.setAttribute("msg", "优惠券超出使用时间限制！");
            return "/account/discountError";
        }
        if (discount.getStatus() == 0) {
            request.setAttribute("msg", "优惠券不可用！");
            return "/account/discountError";
        }
        if (discount.getProtype() == 0 && discount.getProid().length() == 1 && Integer.parseInt(discount.getProid()) == 0) {
            //type=0 id =0
            discount.setPname("全部商品");
        } else if (discount.getProtype() == 1 && discount.getProid().length() == 1 && Integer.parseInt(discount.getProid()) == 0) {
            //指定是分类但没选分类id
            discount.setPname("全部商品");
        } else if (discount.getProtype() == 1 && discount.getProid().length() > 1) {
            //指定分类 指定分类id
            List list = Arrays.asList(discount.getProid().split(","));
            List<String> a = catalogService.selectNameListByIds(list);
            discount.setPname("可用分类："+a.toString());
        }else if (discount.getProtype() == 2 && discount.getProid().length() > 1) {
            //指定商品 指定商品id
            List list = Arrays.asList(discount.getProid().split(","));
            List<String> a = productService.selectNameListByIds(list);
            discount.setPname("可用商品："+a.toString());
        }else {
            discount.setPname("异常数据");
        }
        request.setAttribute("discount", discount);
        return "/account/discountChange";
    }



    //跳转兑换页面
    @RequestMapping(value = "payDiscount",method = RequestMethod.POST)
    @ResponseBody
    public String payDiscount(String id,HttpServletRequest request){
        Account acc = (Account) LoginUserHolder.getLoginAccount();
        if (acc == null || StringUtils.isBlank(acc.getAccount())) {
            return toLogin;
        }
        if (id == null || id == "") {
            return "不存在的优惠券！";
        }
        Discount discount = discountService.selectById(id);
        if (discount == null) {
            return "无效的优惠券！";
        }
        if(discount.getLevcount()<=0){
            return "优惠券已抢完抱歉！";
        }
        String ymd = sdf.format(new Date());
        if (discount.getBegintime().compareTo(ymd) <= 0 && discount.getEndtime().compareTo(ymd) >= 0) {

        }else{
            return "优惠券超出使用时间限制！";
        }
        if(discount.getStatus() == 0) {
            return "优惠券不可用！";
        }
        //todo 会员等级限制
        if (discount.getLimget() > 0) {
            DiscountDetail search = new DiscountDetail();
            Map map = new HashMap();
            map.put("disId", id);
            map.put("account", acc.getId());
            if(discountDetailService.getHasCount(map)>discount.getLimget()) {
                return "您领取次数已达限制！";
            }
        }
        LifeCoinLog lifeCoinLog = new LifeCoinLog();
        lifeCoinLog.setUserid(Integer.parseInt(acc.getId()));
        lifeCoinLog.setNeedNum(discount.getConvertnum());
        LifeCoinPay lifeCoinPay = lifeCoinService.doLifeCoinPay(lifeCoinLog);
        //不成功时返回
        if (!lifeCoinPay.isPayStatus()) {
            return lifeCoinPay.getMsg();
        } else {
            //领取成功就把优惠券减少
            discount.setLevcount(discount.getLevcount()-1);
            discountService.update(discount);
            //新增详细绑在用户上的
            DiscountDetail discountDetail = new DiscountDetail();
            discountDetail.setDisid(Integer.parseInt(discount.getId()));
            discountDetail.setGtime(DateTimeUtil.getCurrDate(DateTimeUtil.FORMAT_ONE));
            discountDetail.setStatus(1);//标记可用
            discountDetail.setConverttype(discount.getConverttype());
            discountDetail.setConvertnum(discount.getConvertnum());
            discountDetail.setAccountid(Integer.parseInt(acc.getId()));
            discountDetailService.insert(discountDetail);
            return "success";
        }
    }
}

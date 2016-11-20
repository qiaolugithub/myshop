package net.jeeshop.web.action.front.discount;

import net.jeeshop.core.Services;
import net.jeeshop.core.util.DateTimeUtil;
import net.jeeshop.services.front.account.bean.Account;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import net.jeeshop.services.front.discountDetail.DiscountDetailService;
import net.jeeshop.services.front.discountDetail.bean.DiscountDetail;
import net.jeeshop.web.action.BaseController;
import net.jeeshop.web.util.LoginUserHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
    private DiscountDetailService discountDetailService;

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

        Map map = new HashMap();
        map.put("disId", id);
        map.put("account", acc.getId());
        int count = discountDetailService.getHasCount(map);

        if (count >= discount.getLimget() && discount.getLimget()!=0) {
            return "count";
        }else {

        }
        return "success";
    }
}

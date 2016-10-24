package net.jeeshop.web.action.front.discount;

import net.jeeshop.core.Services;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import net.jeeshop.web.action.BaseController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Qiao on 2016/9/13.
 */
@Controller("FrontDicountController")
@RequestMapping("dicount")
public class DiscountAction extends BaseController<Discount> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DiscountAction.class);
    private static final long serialVersionUID = 1L;
    @Autowired
    private DiscountService discountService;

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




}

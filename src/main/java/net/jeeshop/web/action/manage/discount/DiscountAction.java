package net.jeeshop.web.action.manage.discount;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.manage.discount.DiscountService;
import net.jeeshop.services.manage.discount.bean.Discount;
import net.jeeshop.web.action.BaseController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Qiao on 2016/9/13.
 */
@Controller("ManageDicountController")
@RequestMapping("/manage/discount")
public class DiscountAction extends BaseController<Discount> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DiscountAction.class);
    private static final long serialVersionUID = 1L;
    @Autowired
    private DiscountService discountService;
    @Override
    protected void selectListAfter(PagerModel pager) {
        pager.setPagerUrl(page_toList);
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public Services<Discount> getService() {
        return discountService;
    }


    private static final String page_toList = "/manage/discount/discountList";
    private DiscountAction(){
        super.page_toList = page_toList;
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

package net.jeeshop.web.action.manage.discount;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.manage.discount.DiscountService;
import net.jeeshop.services.manage.discount.bean.Discount;
import net.jeeshop.web.action.BaseController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private static final String page_toAdd = "/manage/discount/discountEdit";
    private static final String page_toEdit = "/manage/discount/discountEdit";

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DiscountAction(){
        super.page_toList = page_toList;
        super.page_toAdd = page_toAdd;
        super.page_toEdit = page_toEdit;
    }

    @Override
    public String insert(HttpServletRequest request, @ModelAttribute("e") Discount discount, RedirectAttributes flushAttrs) throws Exception {
        if (discount.getProtype() == null) {
            discount.setProtype(0);
        }
        if (discount.getProid() == null) {
            discount.setProid(0);
        }
        if (discount.getLevcount() == null) {
            discount.setLevcount(discount.getAllcount());
        }
        if (discount.getConvertnum() == null) {
            discount.setConvertnum(0d);
        }
        if(discount.getTrank()==null){
            discount.setTrank(0);
        }
        discount.setCreatetime(sdf.format(new Date()));
        return super.insert(request, discount, flushAttrs);
    }
}

package net.jeeshop.web.action.manage.lifecoin;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.catalog.CatalogService;
import net.jeeshop.services.front.product.ProductService;
import net.jeeshop.services.manage.discount.DiscountService;
import net.jeeshop.services.manage.discount.bean.Discount;
import net.jeeshop.services.manage.lifecoin.LifeCoinService;
import net.jeeshop.services.manage.lifecoin.bean.LifeCoin;
import net.jeeshop.web.action.BaseController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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


    public void setLifeCoinService(LifeCoinService lifeCoinService) {
        this.lifeCoinService = lifeCoinService;
    }

    @Override
    public Services<LifeCoin> getService() {
        return lifeCoinService;
    }



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
    public String selectList(HttpServletRequest request,@ModelAttribute("e") LifeCoin e) throws Exception {
        try {
            super.selectList(request, e);
            PagerModel pager = (PagerModel)request.getAttribute("pager");
            request.setAttribute("pager", pager);
            LifeCoin coin = lifeCoinService.getSumAndCount();
            request.setAttribute("sum",  coin.getSumNum());
            request.setAttribute("count",  coin.getCountNum());
            return page_toList;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}

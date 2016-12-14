package net.jeeshop.web.action.manage.discount;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.catalog.CatalogService;
import net.jeeshop.services.manage.discount.DiscountService;
import net.jeeshop.services.manage.discount.bean.Discount;
import net.jeeshop.services.front.product.ProductService;
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
@Controller("ManageDicountController")
@RequestMapping("/manage/discount/")
public class DiscountAction extends BaseController<Discount> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DiscountAction.class);
    private static final long serialVersionUID = 1L;
    @Autowired
    private DiscountService discountService;


    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public Services<Discount> getService() {
        return discountService;
    }

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ProductService productService;

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
    public String selectList(HttpServletRequest request,@ModelAttribute("e") Discount e) throws Exception {
        try {
            super.selectList(request, e);
            PagerModel pager = (PagerModel)request.getAttribute("pager");

            List<Discount> tempList = new ArrayList<Discount>();
            List<Discount> list2 = pager.getList();
            String ymd = sdf.format(new Date());
            for (Discount discountObj : list2) {
                //默认超时了
                discountObj.setOverTime(1);
                //开始时间和结束时间内
                if(discountObj.getBegintime().compareTo(ymd)<=0&&discountObj.getEndtime().compareTo(ymd)>=0){
                    discountObj.setOverTime(0);//设置没超时
                }
                if (discountObj.getProtype() == 0 && discountObj.getProid().length() == 1 && Integer.parseInt(discountObj.getProid()) == 0) {
                    //type=0 id =0
                    discountObj.setPname("全部商品");
                } else if (discountObj.getProtype() == 1 && discountObj.getProid().length() == 1 && Integer.parseInt(discountObj.getProid()) == 0) {
                    //指定是分类但没选分类id
                    discountObj.setPname("全部商品");
                } else if (discountObj.getProtype() == 1 && discountObj.getProid().length() > 1) {
                    //指定分类 指定分类id
                    List list = Arrays.asList(discountObj.getProid().split(","));
                    List<String> a = catalogService.selectNameListByIds(list);
                    discountObj.setPname("可用分类："+a.toString());
                }else if (discountObj.getProtype() == 2 && discountObj.getProid().length() > 1) {
                    //指定商品 指定商品id
                    List list = Arrays.asList(discountObj.getProid().split(","));
                    List<String> a = productService.selectNameListByIds(list);
                    discountObj.setPname("可用商品："+a.toString());
                }else {
                    discountObj.setPname("异常数据");
                }
                tempList.add(discountObj);
            }
            pager.setList(tempList); //把数据转换后的重新放回list
            request.setAttribute("pager", pager);
            return page_toList;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public String insert(HttpServletRequest request, @ModelAttribute("e") Discount discount, RedirectAttributes flushAttrs) throws Exception {
        if (discount.getProtype() == null ) {
            discount.setProtype(0);
        }
        if (discount.getProid() == null || discount.getProid()=="") {
            discount.setProid("0");
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

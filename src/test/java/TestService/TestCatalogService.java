package TestService;

import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.core.util.DateTimeUtil;
import net.jeeshop.services.front.catalog.CatalogService;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import net.jeeshop.services.front.discountDetail.DiscountDetailService;
import net.jeeshop.services.front.discountDetail.bean.DiscountDetail;
import net.jeeshop.services.front.product.ProductService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Qiao on 2016/11/15.
 */
public class TestCatalogService {
    @Autowired
    public static CatalogService catalogService;

    @Autowired
    public static ProductService productService;

    @Autowired
    public static DiscountDetailService discountDetailService;

    @Autowired
    public static DiscountService discountService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeClass
    public static void init() {//junit之前init spring
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");//这里路径之前没有配对于是一直出错
     /*   catalogService = (CatalogService)context.getBean("catalogServiceFront");

        productService = (ProductService) context.getBean("productServiceFront");*/
        discountDetailService = (DiscountDetailService) context.getBean("discountDetailServiceFront");
        discountService = (DiscountService) context.getBean("discountServiceFront");
    }

    //@Test
    public  void test1() throws Exception {
        String str = "24,25,26";
        List list = Arrays.asList(str.split(","));
        List<String> a = catalogService.selectNameListByIds(list);
        a.size();


        String str2 = "10000,10001,10008";
        List list2 = Arrays.asList(str2.split(","));
        List<String> b = productService.selectNameListByIds(list2);
        b.size();
    }

   // @Test
    public void test2() {
        DiscountDetail discountDetail = new DiscountDetail();
        discountDetail.setDisid(3);
        discountDetail.setAccountid(32);
        discountDetail.setGtime(DateTimeUtil.getCurrDate(DateTimeUtil.FORMAT_ONE));
        discountDetail.setConvertnum(0d);
        discountDetail.setConverttype(0);
        discountDetail.setStatus(1);
        discountDetailService.insert(discountDetail);
    }


    @Test
    public void test3() {
        Discount discount = new Discount();
        discount.setAccount("32");
        String ymd = sdf.format(new Date());
        discount.setQueryDate(ymd);
        PagerModel pager = discountService.selectPageList(discount);
        pager.getList();
    }
}

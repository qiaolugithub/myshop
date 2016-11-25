/*
package test;

import net.jeeshop.core.Services;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml", "classpath*:spring/front/applicationContex*.xml", "classpath*:spring/manage/applicationContex*.xml"})
public class DiscountTest {
    @Autowired
    private DiscountService discountService;

    public Services<Discount> getService() {
        return discountService;
    }


    @Test
    public void testFind() {
        Discount discount = new Discount();
        discount.setName("11");
        discount.setFacevale(200d);
        discount.setBegintime(new Date());
        discount.setEndtime(new Date());
        discount.setProtype(1);
        discount.setProid(1);
        discount.setConverttype(1);
        discount.setCuttype(1);
        discountService.insert(discount);
    }

}
*/

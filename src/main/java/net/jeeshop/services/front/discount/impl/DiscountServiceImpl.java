package net.jeeshop.services.front.discount.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.core.front.SystemManager;
import net.jeeshop.services.front.catalog.CatalogService;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import net.jeeshop.services.front.discount.dao.DiscountDao;
import net.jeeshop.services.front.product.ProductService;
import net.jeeshop.services.front.product.bean.Product;
import net.jeeshop.services.front.product.bean.ProductStockInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Qiao on 2016/9/13.
 */
@Service("discountServiceFront")
public class DiscountServiceImpl extends ServersManager<Discount, DiscountDao> implements
        DiscountService {
    private static final Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);
    @Resource(name = "discountDaoFront")
    @Override
    public void setDao(DiscountDao dicountDao) {
        this.dao = dicountDao;
    }

    @Resource
    private CatalogService catalogService;

    @Resource
    private ProductService productService;

    public PagerModel selectPageList3(Discount e) {
        return dao.selectPageList3(e);
    }

    @Override
    public List<Discount> getUserDiscountList(Discount e) {
        List<Discount> list1 =dao.getUserDiscountList(e);
        List<Discount> tempList1 = new ArrayList<Discount>();
        for (Discount discountObj : list1) {
            if (Integer.parseInt(discountObj.getDisProType())== 0 && discountObj.getDisProId().length() == 1 && Integer.parseInt(discountObj.getDisProId()) == 0) {
                //type=0 id =0
                discountObj.setPname("全部商品");
                discountObj.setOk(true);
            } else if (Integer.parseInt(discountObj.getDisProType()) ==1 && discountObj.getDisProId().length() == 1 && Integer.parseInt(discountObj.getDisProId()) == 0) {
                //指定是分类但没选分类id
                discountObj.setPname("全部商品");
                discountObj.setOk(true);
            } else if (Integer.parseInt(discountObj.getDisProType()) == 1 && discountObj.getDisProId().length() > 1) {
                //指定分类 指定分类id
                List list = Arrays.asList(discountObj.getDisProId().split(","));
                List<String> a = catalogService.selectNameListByIds(list);
                discountObj.setPname("可用分类："+a.toString());
                discountObj.setOk(true);
            }else if (Integer.parseInt(discountObj.getDisProType()) == 2 && discountObj.getDisProId().length() > 1) {
                //指定商品 指定商品id
                List list = Arrays.asList(discountObj.getDisProId().split(","));
                if (e.getProductList().size() > 0) {
                    List ids = new ArrayList();
                    for(int i=0;i<e.getProductList().size();i++) {
                        ids.add(e.getProductList().get(i).getId());
                    }
                    if (Collections.disjoint(list, ids)) {
                        discountObj.setOk(false);
                    }else{
                        discountObj.setOk(true);
                    }
                }else{    discountObj.setOk(false);}
                List<String> a = productService.selectNameListByIds(list);
                discountObj.setPname("可用商品：" + a.toString());
            }else {
                discountObj.setPname("异常数据");
            }
            tempList1.add(discountObj);
        }
        return tempList1;
    }


}

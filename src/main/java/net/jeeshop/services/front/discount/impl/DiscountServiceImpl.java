package net.jeeshop.services.front.discount.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import net.jeeshop.services.front.discount.dao.DiscountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public PagerModel selectPageList3(Discount e) {
        return dao.selectPageList3(e);
    }

    @Override
    public List<Discount> getUserDiscountList(Discount e) {
        return dao.getUserDiscountList(e);
    }


}

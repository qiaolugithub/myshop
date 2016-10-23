package net.jeeshop.services.front.discount.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.discount.DiscountService;
import net.jeeshop.services.front.discount.bean.Discount;
import net.jeeshop.services.front.discount.dao.DicountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Qiao on 2016/9/13.
 */
@Service("discountServiceFront")
public class DiscountServiceImpl extends ServersManager<Discount, DicountDao> implements
        DiscountService {
    private static final Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);
    @Resource(name = "dicountDaoFront")
    @Override
    public void setDao(DicountDao dicountDao) {
        this.dao = dicountDao;
    }

    public PagerModel selectPageList2(Discount e) {
        return dao.selectPageList2(e);
    }
}

package net.jeeshop.services.manage.discount.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.services.manage.discount.DiscountService;
import net.jeeshop.services.manage.discount.bean.Discount;
import net.jeeshop.services.manage.discount.dao.DicountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Qiao on 2016/9/13.
 */
@Service("discountServiceManage")
public class DiscountServiceImpl extends ServersManager<Discount, DicountDao> implements
        DiscountService {
    @Resource(name = "dicountDaoManage")
    @Override
    public void setDao(DicountDao dicountDao) {
        this.dao = dicountDao;
    }
}

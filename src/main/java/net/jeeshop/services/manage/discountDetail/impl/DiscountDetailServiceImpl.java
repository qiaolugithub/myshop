package net.jeeshop.services.manage.discountDetail.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.services.manage.discountDetail.DiscountDetailService;
import net.jeeshop.services.manage.discountDetail.bean.DiscountDetail;
import net.jeeshop.services.manage.discountDetail.dao.DiscountDetailDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Qiao on 2016/9/13.
 */
@Service("discountDetailServiceManage")
public class DiscountDetailServiceImpl extends ServersManager<DiscountDetail, DiscountDetailDao> implements
        DiscountDetailService {
    private static final Logger logger = LoggerFactory.getLogger(DiscountDetailServiceImpl.class);
    @Resource(name = "dicountDetailDaoManage")
    @Override
    public void setDao(DiscountDetailDao dicountDetailDao) {
        this.dao = dicountDetailDao;
    }
}

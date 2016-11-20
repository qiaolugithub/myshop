package net.jeeshop.services.front.discountDetail.impl;


import net.jeeshop.core.ServersManager;
import net.jeeshop.services.front.discountDetail.DiscountDetailService;
import net.jeeshop.services.front.discountDetail.bean.DiscountDetail;
import net.jeeshop.services.front.discountDetail.dao.DiscountDetailDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


/**
 * Created by Qiao on 2016/11/13.
 */
@Service("discountDetailServiceFront")
public class DiscountDetailServiceImpl extends ServersManager<DiscountDetail, DiscountDetailDao> implements
        DiscountDetailService {
private static final Logger logger = LoggerFactory.getLogger(DiscountDetailServiceImpl.class);
        @Resource(name = "discountDetailDaoFront")
        @Override
        public void setDao(DiscountDetailDao discountDetailDao) {
            this.dao = discountDetailDao;
        }

    @Override
    public Integer getHasCount(Map map) {
        return dao.getHasCount(map);
    }
}

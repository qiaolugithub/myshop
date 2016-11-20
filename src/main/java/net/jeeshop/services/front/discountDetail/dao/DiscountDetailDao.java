package net.jeeshop.services.front.discountDetail.dao;

import net.jeeshop.core.DaoManager;
import net.jeeshop.services.front.discountDetail.bean.DiscountDetail;

import java.util.Map;


public interface DiscountDetailDao extends DaoManager<DiscountDetail> {
    Integer getHasCount(Map map);
}
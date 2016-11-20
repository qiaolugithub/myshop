package net.jeeshop.services.front.discountDetail;

import net.jeeshop.core.Services;
import net.jeeshop.services.front.discountDetail.bean.DiscountDetail;

import java.util.Map;

/**
 * Created by Qiao on 2016/9/13.
 */
public interface DiscountDetailService extends Services<DiscountDetail> {
    Integer getHasCount(Map map);
}

package net.jeeshop.services.front.discount;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.discount.bean.Discount;

/**
 * Created by Qiao on 2016/9/13.
 */
public interface DiscountService extends Services<net.jeeshop.services.front.discount.bean.Discount> {
    PagerModel selectPageList2(Discount e);
}

package net.jeeshop.services.front.discount.dao;

import net.jeeshop.core.DaoManager;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.front.discount.bean.Discount;

/**
 * Created by Qiao on 2016/9/13.
 */
public interface DicountDao extends DaoManager<Discount> {
    PagerModel selectPageList2(Discount e);
}

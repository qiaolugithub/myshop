package net.jeeshop.services.manage.lifecoin.dao;


import net.jeeshop.core.DaoManager;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.manage.lifecoin.bean.LifeCoin;

/**
 * Created by Qiao on 2016/12/10.
 */
public interface LifeCoinDao extends DaoManager<LifeCoin> {
    /**
     * 分页查询
     *
     * @param e
     * @return public PagerModel selectPageListAllUserLifeCoin(LifeCoin e);
     */

    LifeCoin getSumAndCount();
}

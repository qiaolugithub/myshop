package net.jeeshop.services.manage.lifecoin;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.manage.lifecoin.bean.LifeCoin;

import java.util.List;

/**
 * Created by Qiao on 2016/12/10.
 */
public interface LifeCoinService extends Services<LifeCoin> {

   /* public PagerModel selectPageListAllUserLifeCoin(LifeCoin e);*/

    public LifeCoin getSumAndCount();

   String exportAllUserLifeCoinList();
}

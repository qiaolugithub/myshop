package net.jeeshop.services.manage.lifecoin.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.manage.lifecoin.LifeCoinService;
import net.jeeshop.services.manage.lifecoin.bean.LifeCoin;
import net.jeeshop.services.manage.lifecoin.dao.LifeCoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Qiao on 2016/12/10.
 */
@Service("lifeCofinServiceManage")
public class LifeCofinServiceImpl extends ServersManager<LifeCoin, LifeCoinDao> implements
        LifeCoinService {
    @Autowired
    @Override
    public void setDao(LifeCoinDao LifeCoinDao) {
        this.dao = LifeCoinDao;
    }

 /*   @Override
    public PagerModel selectPageListAllUserLifeCoin(LifeCoin e) {
        return dao.selectPageListAllUserLifeCoin(e);
    }*/

    @Override
    public LifeCoin getSumAndCount() {
        return dao.getSumAndCount();
    }
}

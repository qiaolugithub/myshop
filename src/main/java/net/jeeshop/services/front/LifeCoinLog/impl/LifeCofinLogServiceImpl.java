package net.jeeshop.services.front.lifecoinlog.impl;

import net.jeeshop.core.ServersManager;
import net.jeeshop.services.front.lifecoinlog.LifeCoinLogService;
import net.jeeshop.services.front.lifecoinlog.bean.LifeCoinLog;
import net.jeeshop.services.front.lifecoinlog.dao.LifeCoinLogDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Qiao on 2016/12/10.
 */
@Service("lifeCofinLogServiceFront")
public class LifeCofinLogServiceImpl extends ServersManager<LifeCoinLog, LifeCoinLogDao> implements
        LifeCoinLogService{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LifeCofinLogServiceImpl.class);
    @Autowired
    @Override
    public void setDao(LifeCoinLogDao lifeCoinLogDao) {
        this.dao = lifeCoinLogDao;
    }

}

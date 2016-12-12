package net.jeeshop.services.front.lifecoin;

import net.jeeshop.core.Services;
import net.jeeshop.services.common.LifeCoinPay;
import net.jeeshop.services.front.lifecoinlog.bean.LifeCoinLog;
import net.jeeshop.services.front.lifecoin.bean.LifeCoin;

/**
 * Created by Qiao on 2016/12/10.
 */
public interface LifeCoinService extends Services<LifeCoin> {
    /*
    * 0失败 1成功
     */
    int checkUserLifeCoin(LifeCoin lifeCoin);


    LifeCoinPay doLifeCoinPay(LifeCoinLog lifeCoinLog);
}

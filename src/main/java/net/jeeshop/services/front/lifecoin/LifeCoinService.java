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

    /**
     * 检查是否锁定  返回true 是锁了
     * @param accId
     * @return
     */
    public boolean checkLock(String accId);

    /**
     * 判断上次交易是否大于三次确认
     * @param accId
     * @return
     */
    public boolean checkLastDeal(String accId);
}

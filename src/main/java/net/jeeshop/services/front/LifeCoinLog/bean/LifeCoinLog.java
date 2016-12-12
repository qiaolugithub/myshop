package net.jeeshop.services.front.lifecoinlog.bean;

import java.io.Serializable;

/**
 * Created by Qiao on 2016/12/11.
 */
public class LifeCoinLog  extends net.jeeshop.services.common.LifeCoinLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private Double needNum;//需要支付的价格

    public void clear() {
        super.clear();
        needNum = null;
    }

    public Double getNeedNum() {
        return needNum;
    }

    public void setNeedNum(Double needNum) {
        this.needNum = needNum;
    }
}

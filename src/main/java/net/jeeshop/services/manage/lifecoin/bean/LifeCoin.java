package net.jeeshop.services.manage.lifecoin.bean;

import java.io.Serializable;

/**
 * Created by Qiao on 2016/12/5.
 */
public class LifeCoin extends net.jeeshop.services.common.LifeCoin 	implements Serializable {
    private static final long serialVersionUID = 1L;
    private String account;
    private String tel;
    private Double sumNum;
    private Integer countNum;

    public void clear() {
        super.clear();
        account = null;
        tel = null;
        sumNum = null;
        countNum = null;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public Double getSumNum() {
        return sumNum;
    }

    public void setSumNum(Double sumNum) {
        this.sumNum = sumNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

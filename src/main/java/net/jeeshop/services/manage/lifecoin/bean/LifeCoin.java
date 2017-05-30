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


    private String nickname;
    private String email;
    private String isLocked;

    public void clear() {
        super.clear();
        account = null;
        tel = null;
        sumNum = null;
        countNum = null;
        nickname = null;
        email = null;
        isLocked = null;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }
}

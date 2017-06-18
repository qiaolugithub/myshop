package net.jeeshop.services.common;

import java.io.Serializable;

import net.jeeshop.core.dao.QueryModel;

public class LifeCoin extends QueryModel implements Serializable {
    private String id;

    /** t_lifecoin.accountId */
    private Integer accountid;

    /** 燊活币个数 */
    private Double coincount;

    /** 燊活币地址 */
    private String coinaddress;

    /** 是否锁定0否1是 */
    private Integer islock;

    /** 备注 */
    private String remark;


    public void clear() {
        super.clear();
        id = null;
        accountid = null;
        coincount = 0D;
        coinaddress = null;
        islock = null;
        remark = null;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Double getCoincount() {
        return coincount;
    }

    public void setCoincount(Double coincount) {
        this.coincount = coincount;
    }

    public String getCoinaddress() {
        return coinaddress;
    }

    public void setCoinaddress(String coinaddress) {
        this.coinaddress = coinaddress == null ? null : coinaddress.trim();
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
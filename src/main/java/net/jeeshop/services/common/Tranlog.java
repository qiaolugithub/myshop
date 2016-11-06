package net.jeeshop.services.common;

import net.jeeshop.core.dao.QueryModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Tranlog extends QueryModel implements Serializable {
    /** t_tranlog.id */
    private String id;

    /** 生成时间 */
    private String createTime;

    /** 存入金额 */
    private BigDecimal depositNum;

    /** 花费 */
    private BigDecimal payNum;

    /** 1钱包2订单3优惠券 */
    private Integer type;

    /** 地址，订单id，优惠券详细的id */
    private String tonum;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getDepositNum() {
        return depositNum;
    }

    public void setDepositNum(BigDecimal depositNum) {
        this.depositNum = depositNum;
    }

    public BigDecimal getPayNum() {
        return payNum;
    }

    public void setPayNum(BigDecimal payNum) {
        this.payNum = payNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTonum() {
        return tonum;
    }

    public void setTonum(String tonum) {
        this.tonum = tonum == null ? null : tonum.trim();
    }
}
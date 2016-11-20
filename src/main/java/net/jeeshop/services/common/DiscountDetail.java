package net.jeeshop.services.common;

import net.jeeshop.core.dao.QueryModel;

import java.io.Serializable;
import java.util.Date;

public class DiscountDetail extends QueryModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /** t_discount_detail.id */

    /** 优惠券id */
    private Integer disid;

    /** 获取时间 */
    private String gtime;

    /** 使用时间 */
    private String usetime;

    /** 0不可用(作废)1可用2已使用 */
    private Integer status;

    /** 兑换方式0免费，1人民币，2生活币，3积分 */
    private Integer converttype;

    /** 兑换需要付多少钱 */
    private Double convertnum;

    /** 用户id */
    private Integer accountid;

    /** 订单id */
    private Integer orderid;




    public Integer getDisid() {
        return disid;
    }

    public void setDisid(Integer disid) {
        this.disid = disid;
    }

    public String getGtime() {
        return gtime;
    }

    public void setGtime(String gtime) {
        this.gtime = gtime;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getConverttype() {
        return converttype;
    }

    public void setConverttype(Integer converttype) {
        this.converttype = converttype;
    }

    public Double getConvertnum() {
        return convertnum;
    }

    public void setConvertnum(Double convertnum) {
        this.convertnum = convertnum;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}
package net.jeeshop.services.common;

import net.jeeshop.core.dao.page.PagerModel;

import java.io.Serializable;
import java.util.Date;

public class LifeCoinLog extends PagerModel implements Serializable {
    /** t_lifecoinlog.id */
    private String id;

    /** lifecoin表的主键 */
    private Integer lifecoinid;

    /** 记录时间 */
    private Date createtime;

    /** 入账多少 */
    private Double innum;

    /** 出账 */
    private Double outnum;

    /** 从哪个地址转入的 */
    private String formaddress;

    /** 转给某个账户 */
    private String toaddress;

    /** 备注 */
    private String remark;

    /** 执行结果1成功，2失败 */
    private Integer status;

    /** 用户id */
    private Integer userid;

    /** 支付类型 1：人民币2：虚拟币3：积分 */
    private Integer type;

    private String ordernum;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLifecoinid() {
        return lifecoinid;
    }

    public void setLifecoinid(Integer lifecoinid) {
        this.lifecoinid = lifecoinid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getInnum() {
        return innum;
    }

    public void setInnum(Double innum) {
        this.innum = innum;
    }

    public Double getOutnum() {
        return outnum;
    }

    public void setOutnum(Double outnum) {
        this.outnum = outnum;
    }

    public String getFormaddress() {
        return formaddress;
    }

    public void setFormaddress(String formaddress) {
        this.formaddress = formaddress == null ? null : formaddress.trim();
    }

    public String getToaddress() {
        return toaddress;
    }

    public void setToaddress(String toaddress) {
        this.toaddress = toaddress == null ? null : toaddress.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
}
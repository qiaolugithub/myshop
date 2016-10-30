package net.jeeshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Discount implements Serializable {
    /** t_discount.id */
    private Integer id;

    private String name;

    private BigDecimal facevale;

    private Date begintime;

    private Date endtime;

    private Integer protype;

    private Integer proid;

    private Integer allcount;

    private Integer levcount;

    private Integer converttype;

    private BigDecimal convertnum;

    private Integer cuttype;

    private BigDecimal cutnum;

    private Integer trank;

    private Integer limget;

    private String remark;

    private Date createtime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getFacevale() {
        return facevale;
    }

    public void setFacevale(BigDecimal facevale) {
        this.facevale = facevale;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getProtype() {
        return protype;
    }

    public void setProtype(Integer protype) {
        this.protype = protype;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getAllcount() {
        return allcount;
    }

    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
    }

    public Integer getLevcount() {
        return levcount;
    }

    public void setLevcount(Integer levcount) {
        this.levcount = levcount;
    }

    public Integer getConverttype() {
        return converttype;
    }

    public void setConverttype(Integer converttype) {
        this.converttype = converttype;
    }

    public BigDecimal getConvertnum() {
        return convertnum;
    }

    public void setConvertnum(BigDecimal convertnum) {
        this.convertnum = convertnum;
    }

    public Integer getCuttype() {
        return cuttype;
    }

    public void setCuttype(Integer cuttype) {
        this.cuttype = cuttype;
    }

    public BigDecimal getCutnum() {
        return cutnum;
    }

    public void setCutnum(BigDecimal cutnum) {
        this.cutnum = cutnum;
    }

    public Integer getTrank() {
        return trank;
    }

    public void setTrank(Integer trank) {
        this.trank = trank;
    }

    public Integer getLimget() {
        return limget;
    }

    public void setLimget(Integer limget) {
        this.limget = limget;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
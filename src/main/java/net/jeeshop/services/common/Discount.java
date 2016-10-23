package net.jeeshop.services.common;

import net.jeeshop.core.dao.QueryModel;

import java.io.Serializable;
public class Discount extends QueryModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /** t_discount.id */
    private String id;

    private String name;

    private Double facevale;

    private String begintime;

    private String endtime;

    private Integer protype;

    private Integer proid;

    private Integer allcount;

    private Integer levcount;

    private Integer converttype;

    private Double convertnum;

    private Integer cuttype;

    private Double cutnum;

    private Integer trank;

    private Integer limget;

    private String remark;

    private String createtime;

    private Integer status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getFacevale() {
        return facevale;
    }

    public void setFacevale(Double facevale) {
        this.facevale = facevale;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
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

    public Double getConvertnum() {
        return convertnum;
    }

    public void setConvertnum(Double convertnum) {
        this.convertnum = convertnum;
    }

    public Integer getCuttype() {
        return cuttype;
    }

    public void setCuttype(Integer cuttype) {
        this.cuttype = cuttype;
    }

    public Double getCutnum() {
        return cutnum;
    }

    public void setCutnum(Double cutnum) {
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
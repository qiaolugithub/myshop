package net.jeeshop.services.manage.discount.bean;

import java.io.Serializable;
import java.util.List;

public class Discount extends net.jeeshop.services.common.Discount implements
        Serializable {
    private static final long serialVersionUID = 1L;

    private List<Discount> discountList;//
    private String queryDate;//做查询条件用的时间
    private String pname;//可用商品：所有，指定商品，指定分类
    private Integer overTime;//是否超时  0 未超时 1超时

    public void clear() {
        super.clear();
        if(discountList!=null){
            for(int i=0;i<discountList.size();i++){
                discountList.get(i).clear();
            }
            discountList.clear();
            discountList = null;
        }
        queryDate=null;
        pname = null;
        overTime = null;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }


    public String getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(String queryDate) {
        this.queryDate = queryDate;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
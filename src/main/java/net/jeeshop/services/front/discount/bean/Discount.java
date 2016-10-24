package net.jeeshop.services.front.discount.bean;


import java.io.Serializable;
import java.util.List;
public class Discount extends net.jeeshop.services.common.Discount implements
        Serializable {
    private static final long serialVersionUID = 1L;

    private List<Discount> discountList;//

    private  String account;//绑定人id
    private String queryDate;//做查询条件用的时间
    private String canuse;//优惠券能否使用 1可用 2已用 3已过期 4已使用
    private String pname;//可用商品：所有，指定商品，指定分类
    private Integer isGet;//是否领取过






    public void clear() {
        super.clear();
        if(discountList!=null){
			for(int i=0;i<discountList.size();i++){
                discountList.get(i).clear();
			}
            discountList.clear();
            discountList = null;
        }
        account = null;
        isGet = null;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(String queryDate) {
        this.queryDate = queryDate;
    }

    public String getCanuse() {
        return canuse;
    }

    public void setCanuse(String canuse) {
        this.canuse = canuse;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getIsGet() {
        return isGet;
    }

    public void setIsGet(Integer isGet) {
        this.isGet = isGet;
    }
}
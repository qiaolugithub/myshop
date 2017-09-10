package net.jeeshop.services.front.discount.bean;



import net.jeeshop.services.front.product.bean.Product;

import java.io.Serializable;
import java.util.List;
public class Discount extends net.jeeshop.services.common.Discount implements
        Serializable {
    private static final long serialVersionUID = 1L;

    private List<Discount> discountList;//
    private List<Product> productList;
    private boolean isOk;

    private  String account;//绑定人id
    private String queryDate;//做查询条件用的时间
    private String canuse;//优惠券能否使用 1可用 2已用 3已过期 4已使用
    private String pname;//可用商品：所有，指定商品，指定分类
    private Integer isGet;//是否领取过
    private Integer overTime;//是否超时  0 未超时 1超时

    private String disName;
    private String disBeginTime;
    private String disEndTime;
    private String disCutType;
    private String disCutNum;
    private String disConvertType;
    private String disConvertNum;
    private String disFaceVale;
    private String disProType;
    private String disProId;

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean isOk) {
        this.isOk = isOk;
    }

    public void clear() {
        super.clear();
        if(discountList!=null){
			for(int i=0;i<discountList.size();i++){
                discountList.get(i).clear();
			}
            discountList.clear();
            discountList = null;
        }
        if(productList!=null){
            for(int i=0;i<productList.size();i++){
                productList.get(i).clear();
            }
            productList.clear();
            productList = null;
        }
        account = null;
        isGet = null;

       disName = null;
       disBeginTime = null;
       disEndTime = null;
       disCutType = null;
       disCutNum = null;
       disConvertType = null;
       disConvertNum = null;
       disFaceVale = null;
       disProType = null;
       disProId = null;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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


    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getDisBeginTime() {
        return disBeginTime;
    }

    public void setDisBeginTime(String disBeginTime) {
        this.disBeginTime = disBeginTime;
    }

    public String getDisEndTime() {
        return disEndTime;
    }

    public void setDisEndTime(String disEndTime) {
        this.disEndTime = disEndTime;
    }

    public String getDisCutType() {
        return disCutType;
    }

    public void setDisCutType(String disCutType) {
        this.disCutType = disCutType;
    }

    public String getDisCutNum() {
        return disCutNum;
    }

    public void setDisCutNum(String disCutNum) {
        this.disCutNum = disCutNum;
    }

    public String getDisConvertType() {
        return disConvertType;
    }

    public void setDisConvertType(String disConvertType) {
        this.disConvertType = disConvertType;
    }

    public String getDisConvertNum() {
        return disConvertNum;
    }

    public void setDisConvertNum(String disConvertNum) {
        this.disConvertNum = disConvertNum;
    }

    public String getDisFaceVale() {
        return disFaceVale;
    }

    public void setDisFaceVale(String disFaceVale) {
        this.disFaceVale = disFaceVale;
    }

    public String getDisProType() {
        return disProType;
    }

    public void setDisProType(String disProType) {
        this.disProType = disProType;
    }

    public String getDisProId() {
        return disProId;
    }

    public void setDisProId(String disProId) {
        this.disProId = disProId;
    }
}
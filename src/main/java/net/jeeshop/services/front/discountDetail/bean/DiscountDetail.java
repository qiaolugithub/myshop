package net.jeeshop.services.front.discountDetail.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Qiao on 2016/11/13.
 */
public class DiscountDetail extends net.jeeshop.services.common.DiscountDetail implements
        Serializable {
    private static final long serialVersionUID = 1L;

    private List<DiscountDetail> discountDetailList;
    public void clear() {
        super.clear();
        if(discountDetailList!=null){
            for(int i=0;i<discountDetailList.size();i++){
                discountDetailList.get(i).clear();
            }
            discountDetailList.clear();
            discountDetailList = null;
        }
    }

    public List<DiscountDetail> getDiscountDetailList() {
        return discountDetailList;
    }

    public void setDiscountDetailList(List<DiscountDetail> discountDetailList) {
        this.discountDetailList = discountDetailList;
    }
}

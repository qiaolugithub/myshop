package net.jeeshop.services.manage.discount.bean;

import java.io.Serializable;
import java.util.List;

public class Discount extends net.jeeshop.services.common.Discount implements
        Serializable {
    private static final long serialVersionUID = 1L;

    private List<Discount> discountList;//

    public void clear() {
        super.clear();
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }
}
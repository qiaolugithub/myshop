package net.jeeshop.services.front.tranlog.bean;

import java.io.Serializable;

/**
 * Created by Qiao on 2016/11/6.
 */
public class Tranlog extends net.jeeshop.services.common.Tranlog
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.util.List<String> dataList;// 列表，页面显示

    public void clear() {
        super.clear();
        clearList(dataList);
    }

    public java.util.List<String> getDataList() {
        return dataList;
    }

    public void setDataList(java.util.List<String> dataList) {
        this.dataList = dataList;
    }

}
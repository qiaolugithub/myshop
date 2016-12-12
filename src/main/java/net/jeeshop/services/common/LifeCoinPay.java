package net.jeeshop.services.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * Created by Qiao on 2016/12/11.
 */
public class LifeCoinPay implements Serializable {
    private boolean payStatus;//支付状态
    private String msg;//消息内容


   public static String officeAddress;//官方地址
    static{
        InputStream ex = LifeCoinPay.class.getClassLoader().getResourceAsStream("param.properties");
        Properties properties = new Properties();
        try {
            properties.load(ex);
            officeAddress = properties.getProperty("OFFICE_ADDRESS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isPayStatus() {
        return payStatus;
    }

    public void setPayStatus(boolean payStatus) {
        this.payStatus = payStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

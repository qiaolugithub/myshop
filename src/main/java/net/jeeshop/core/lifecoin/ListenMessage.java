package net.jeeshop.core.lifecoin;

import com.azazar.bitcoin.jsonrpcclient.BitcoinException;
import com.azazar.bitcoin.jsonrpcclient.BitcoinJSONRPCClient;

import java.io.Serializable;

/**
 * Created by Qiao on 2016/12/4.
 * 定义消息处理者（消费者）
 */
public class ListenMessage {
    BitcoinJSONRPCClient client = new BitcoinJSONRPCClient();
    public void handleMessage(Serializable message) throws Exception{
        Thread.sleep(3000);
        System.out.println(message);
        if (message.toString().equals("address")) {
            long nw = System.currentTimeMillis();
            System.out.println(client.getAccountAddress("2"));
            System.out.println("time"+(nw-System.currentTimeMillis()));
        }


    }
}
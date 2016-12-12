package net.jeeshop.core.lifecoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by Qiao on 2016/12/4.
 * 定义消息发送者（生产者）
 */
@Component
public class SendMessage {

    @Resource(name = "redisTemplate2")
    private RedisTemplate<String, Object> redisTemplate;


    public void sendMessage(String channel, Serializable message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
/*
package net.jeeshop.core.lifecoin;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
*/
/**
 * 发布消息测试
 *
 * @author nibili 2015年5月14日
 *
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis-pub-sub-demo.xml")
public class RedisPubTest {
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> template;
    */
/**
     * 发布消息
     *
     * @auth nibili 2015年5月14日
     *//*

    @Test
    public void pub() {
        template.convertAndSend("java", "java我发布的消息!");
    }
}*/

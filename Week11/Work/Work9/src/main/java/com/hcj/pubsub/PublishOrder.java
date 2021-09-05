package com.hcj.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;
import java.util.UUID;

/**
 * @author Administrator
 */
public class PublishOrder {
    public PublishOrder(JedisPool jedisPool, String channelName) {
        System.out.println("Start publisher order");
        try (Jedis jedis = jedisPool.getResource()) {
            String strMsg = "";
            for (int i = 0; i < 10; i++) {
                strMsg = UUID.randomUUID().toString();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                jedis.publish(channelName, "order no. " + strMsg);
            }
            jedis.publish(channelName, "");
        }
    }

}

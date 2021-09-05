package com.hcj.dislock.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCount {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void incr(String id){
        if(redisTemplate.boundValueOps(id).get()==null){
            redisTemplate.boundValueOps(id).set("1");
        }else{
            redisTemplate.boundValueOps(id).increment();
        }
    }

    public String get(String id){
        String strId = redisTemplate.boundValueOps(id).get();
        System.out.println("getId="+strId);
        return strId;
    }
}

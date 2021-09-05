package com.hcj.dislock.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SimpleDistributedLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获得锁
     */
    public boolean getLock(String lockId, long millisecond) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",
                millisecond, TimeUnit.MILLISECONDS);
        return success != null && success;
    }

    /**
     * 释放锁
     */
    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }
}

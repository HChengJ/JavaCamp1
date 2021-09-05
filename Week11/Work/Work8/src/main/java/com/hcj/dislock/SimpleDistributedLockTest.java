package com.hcj.dislock;

import com.hcj.dislock.utils.RedisCount;
import com.hcj.dislock.utils.SimpleDistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class SimpleDistributedLockTest {
    private final static String LOCK_ID = "hello";
    @Autowired
    private SimpleDistributedLock simpleDistributedLock;
    @Autowired
    private RedisCount redisCount;

    @Scheduled(cron = "0/1 * * * * ? ")
    public void doSomething() {
        boolean lock = simpleDistributedLock.getLock(LOCK_ID, 2 * 1000);
        if (lock) {
            System.out.println("执行任务");
            redisCount.incr("1");
            redisCount.get("1");
            simpleDistributedLock.releaseLock(LOCK_ID);

        } else {
            System.out.println("没有抢到锁");
        }
    }
}

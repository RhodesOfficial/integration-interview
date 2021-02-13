package com.calpis.interview.redis.lock.impl;

import com.calpis.interview.redis.lock.RedisLockService;
import com.calpis.interview.redis.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/10 19:59
 */
@Service
public class RedisLockServiceImpl implements RedisLockService {

    private static final String LOCK_KEY = "lock";

    private static final long timeout = 1000;

    @Autowired
    private TimeService timeService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private DefaultRedisScript<List> defaultRedisScript;

    @Override
    public boolean tryLock(String id) {
        long start = timeService.getTime();
        while (true) {
            Boolean lock = redisTemplate.opsForValue().setIfAbsent(LOCK_KEY, id, 100, TimeUnit.SECONDS);
            if (lock) {
                return true;
            }
            long l = timeService.getTime() - start;
            if (l >= timeout) {
                return false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean unlock(String id) {
        List<String> keyList = new ArrayList<>();
        keyList.add(LOCK_KEY);
        List<Long> execute = redisTemplate.execute(defaultRedisScript, keyList, id);
        return Objects.equals(1L, execute.get(0));
    }
}

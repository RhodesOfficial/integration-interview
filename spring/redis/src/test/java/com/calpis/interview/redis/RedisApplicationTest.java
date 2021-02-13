package com.calpis.interview.redis;

import com.calpis.interview.redis.lock.RedisLockService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/10 2:15
 */
@SpringBootTest
public class RedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisLockService redisLockService;

    @Autowired
    private RedissonClient redissonClient;

    @SneakyThrows
    @Test
    public void testSentinel() {
        while (true) {
            System.out.println(redisTemplate.opsForValue().get("hello"));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void redisLockTest() {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(redisLockService.tryLock(id));
        System.out.println(redisLockService.unlock(id));
    }

    @Test
    public void hashTest() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 512; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        redisTemplate.opsForHash().putAll("hash", map);
    }
}

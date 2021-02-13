package com.calpis.interview.redis.lock;

/**
 * @Author Calpis
 * @Description 分布式锁
 * @Date 2021/2/10 19:58
 */
public interface RedisLockService {

    /**
     * 加锁
     *
     * @param id
     * @return
     */
    boolean tryLock(String id);

    /**
     * 解锁
     *
     * @param id
     * @return
     */
    boolean unlock(String id);
}

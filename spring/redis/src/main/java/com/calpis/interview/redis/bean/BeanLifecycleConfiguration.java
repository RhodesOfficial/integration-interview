package com.calpis.interview.redis.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/11 17:54
 */
@Configuration
public class BeanLifecycleConfiguration {

    @Bean(destroyMethod = "shutdown")
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(
                30,
                100,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000)
        );
    }

}

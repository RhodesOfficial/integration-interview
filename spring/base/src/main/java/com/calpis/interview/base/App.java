package com.calpis.interview.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/14 1:32
 */
@SpringBootApplication
public class App implements CommandLineRunner, ApplicationContextAware {

//    @Autowired
//    private AnotherService anotherService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
//        redisTemplate.keys("*");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}

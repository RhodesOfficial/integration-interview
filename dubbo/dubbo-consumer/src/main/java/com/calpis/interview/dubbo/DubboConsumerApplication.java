package com.calpis.interview.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 1:27
 */
@EnableDubbo(scanBasePackages = "com.calpis.interview.dubbo")
@SpringBootApplication
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}

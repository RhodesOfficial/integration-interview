package com.calpis.interview.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/6 23:41
 */
@EnableDubbo(scanBasePackages = "com.calpis.interview.dubbo")
@SpringBootApplication
public class DubboMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboMonitorApplication.class, args);
    }
}

package com.calpis.interview.dubbo;

import com.calpis.interview.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/8 1:27
 */
@EnableDubbo(scanBasePackages = "com.calpis.interview.dubbo")
@SpringBootApplication
public class DubboConsumerApplication implements CommandLineRunner {

    @DubboReference
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        while (true) {
            System.out.println(helloService.sayHello("hello"));
        }
    }
}

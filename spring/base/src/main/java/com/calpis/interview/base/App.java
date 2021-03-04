package com.calpis.interview.base;

import com.calpis.interview.base.service.AnotherService;
import com.calpis.interview.base.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/14 1:32
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private AnotherService anotherService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        anotherService.sayHello();
    }
}

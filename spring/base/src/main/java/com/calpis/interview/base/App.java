package com.calpis.interview.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/14 1:32
 */
@SpringBootApplication
public class App {

    private static boolean flag = true;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}

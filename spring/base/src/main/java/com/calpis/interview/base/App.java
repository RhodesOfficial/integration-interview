package com.calpis.interview.base;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/14 1:32
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(App.class, args);
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Thread.sleep(100);
            // main2
            executorService.submit(() -> {
                lock.lock();
                System.out.println("我拿到了");
                while (true) {

                }
            });
        }
    }

    @Override
    public void run(String... args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            executorService.submit(() -> {
                lock.lock();
                System.out.println("我拿到了");
            });
        }
    }

}

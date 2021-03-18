package com.calpis.interview.jdk.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/14 18:22
 */
public class VolatileTest {

    public static int flag = 0;
    public static int test = 0;

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            while (flag == 0) {

            }
            System.out.println("awsl thread-name=" + Thread.currentThread().getName());
        }, "A");
        thread1.start();
        Thread thread2 = new Thread(() -> {
            while (flag == 0) {

            }
            System.out.println("awsl thread-name=" + Thread.currentThread().getName());
        }, "B");
        thread2.start();
        Thread thread3 = new Thread(() -> {
            while (flag == 0) {

            }
            System.out.println("awsl thread-name=" + Thread.currentThread().getName());
        }, "C");
        thread3.start();
        Thread thread4 = new Thread(() -> {
            while (flag == 0) {

            }
            System.out.println("awsl thread-name=" + Thread.currentThread().getName());
        }, "D");
        thread4.start();
        Thread thread5 = new Thread(() -> {
            while (flag == 0) {

            }
            System.out.println("awsl thread-name=" + Thread.currentThread().getName());
        }, "E");
        thread5.start();

        TimeUnit.SECONDS.sleep(5);
        flag = 1;
    }
}

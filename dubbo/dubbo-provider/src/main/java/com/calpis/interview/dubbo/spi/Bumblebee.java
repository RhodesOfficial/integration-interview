package com.calpis.interview.dubbo.spi;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/17 17:37
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}

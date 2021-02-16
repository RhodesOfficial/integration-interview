package com.calpis.interview.jdk.proxy;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/16 16:42
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }
}

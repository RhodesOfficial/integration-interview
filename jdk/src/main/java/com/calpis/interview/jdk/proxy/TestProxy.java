package com.calpis.interview.jdk.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/16 16:42
 */
public class TestProxy {

    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{Subject.class}, (proxy, method, args1) -> {
            System.out.println("hello world");
            return method.invoke(new RealSubject(), args1);
        });
        subject.doSomething();
    }
}

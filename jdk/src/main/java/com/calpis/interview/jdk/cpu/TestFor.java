package com.calpis.interview.jdk.cpu;

import java.lang.reflect.Proxy;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/21 17:09
 */
public class TestFor {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

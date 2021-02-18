package com.calpis.interview.kafka;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/16 0:01
 */
public class Test {

    public static void main(String[] args) {
        synchronized (Test.class) {
            int i = 0;
        }
    }
}

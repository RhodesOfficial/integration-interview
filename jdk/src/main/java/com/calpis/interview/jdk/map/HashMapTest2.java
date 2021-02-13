package com.calpis.interview.jdk.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/13 16:20
 */
public class HashMapTest2 {

    private static Map<Integer, Integer> map = new HashMap<>();
    private static AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) {
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread4.start();
        while (true) {

        }
    }

    static class HashMapThread extends Thread {
        @Override
        public void run() {
            while (ai.get() < 1000000) {
                map.put(ai.get(), ai.get());
                ai.incrementAndGet();
            }
        }
    }
}

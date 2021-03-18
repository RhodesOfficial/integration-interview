package com.calpis.interview.algorithm;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/11 0:40
 */
public class Test {

    private static final ReadWriteLock rw = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        rw.readLock().lock();
        rw.writeLock().lock();
    }


}

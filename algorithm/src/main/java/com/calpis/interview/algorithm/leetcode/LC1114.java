package com.calpis.interview.algorithm.leetcode;

/**
 * @Author Calpis
 * @Description 按序打印
 * @Date 2021/2/12 3:01
 */
public class LC1114 {

    private final Object object = new Object();
    private volatile int flag = 1;

    public LC1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) {
                object.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) {
                object.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) {
                object.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 1;
            object.notifyAll();
        }
    }
}

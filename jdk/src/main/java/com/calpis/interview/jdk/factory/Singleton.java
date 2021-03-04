package com.calpis.interview.jdk.factory;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/3 23:53
 */
public class Singleton {

    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }
}

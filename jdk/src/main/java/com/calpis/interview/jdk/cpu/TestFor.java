package com.calpis.interview.jdk.cpu;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/21 17:09
 */
public class TestFor {

    public static void main(String[] args) throws Exception {

        while (true) {
            Thread.sleep(1000);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

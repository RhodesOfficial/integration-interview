package com.calpis.interview.algorithm;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/11 0:40
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(recursion(100));
    }

    private static int recursion(int n) {
        if (n == 1) {
            return 1;
        }
        n += recursion(n - 1);
        return n;
    }
}

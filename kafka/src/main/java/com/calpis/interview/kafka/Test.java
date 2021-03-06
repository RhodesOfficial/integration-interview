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

    public void merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int p = m-- + n-- -1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}

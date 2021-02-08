package com.calpis.interview.algorithm.sort;

import com.calpis.interview.algorithm.common.CommonUtils;

import java.util.Arrays;

/**
 * @Author Calpis
 * @Description 选择排序
 * @Date 2021/2/4 16:32
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = CommonUtils.generateArr();
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            // 将a[i]和a[i+1...N]中最小的元素交换
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            CommonUtils.swap(a, i, min);
        }
    }
}

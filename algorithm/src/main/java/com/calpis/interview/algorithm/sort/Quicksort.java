package com.calpis.interview.algorithm.sort;

import com.calpis.interview.algorithm.common.CommonUtils;

import java.util.Arrays;

/**
 * @Author Calpis
 * @Description 快速排序
 * @Date 2021/2/4 1:08
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] arr = CommonUtils.generateArr();
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo...i-1], a[i], a[i+1...hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo]; // 切分元素
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < a[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            CommonUtils.swap(a, i, j);
        }
        CommonUtils.swap(a, lo, j); // 将v=a[j]放入正确的位置
        return j; // a[lo...i-1] <= a[i] <= a[i+1...hi] 完成
    }

}

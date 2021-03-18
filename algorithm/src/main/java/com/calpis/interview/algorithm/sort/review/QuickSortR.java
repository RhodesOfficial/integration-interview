package com.calpis.interview.algorithm.sort.review;

import com.calpis.interview.algorithm.common.CommonUtils;

import java.util.Arrays;

import static com.calpis.interview.algorithm.common.CommonUtils.swap;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/15 10:05
 */
public class QuickSortR {

    public static void main(String[] args) {
        int[] arr = CommonUtils.generateArr();
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j);
        sort(arr, j + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi, v = arr[lo];
        while (true) {
            while (arr[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (arr[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, j, lo);
        return j;
    }
}

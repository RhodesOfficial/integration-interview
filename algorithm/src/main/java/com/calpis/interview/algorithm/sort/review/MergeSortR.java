package com.calpis.interview.algorithm.sort.review;

import com.calpis.interview.algorithm.common.CommonUtils;

import java.util.Arrays;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/15 10:20
 */
public class MergeSortR {

    private static int[] aux;

    public static void main(String[] args) {
        int[] arr = CommonUtils.generateArr();
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}

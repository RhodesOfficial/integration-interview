package com.calpis.interview.algorithm.sort;

import com.calpis.interview.algorithm.common.CommonUtils;

import java.util.Arrays;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/23 0:33
 */
public class Training {

    private static int[] aux;

    public static void main(String[] args) {
        int[] arr = CommonUtils.generateArr();
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
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
            } else if (aux[i] > aux[j]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }
}

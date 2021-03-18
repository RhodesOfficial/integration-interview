package com.calpis.interview.algorithm.sort.review;

import com.calpis.interview.algorithm.common.CommonUtils;

import java.util.Arrays;

import static com.calpis.interview.algorithm.common.CommonUtils.swap;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/15 9:43
 */
public class HeapSortR {


    public static void main(String[] args) {
        int[] arr = CommonUtils.generateArr();
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (len - 1) / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < len && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < len && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }
}

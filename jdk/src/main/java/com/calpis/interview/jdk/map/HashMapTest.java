package com.calpis.interview.jdk.map;

import com.google.gson.Gson;
import org.apache.lucene.util.RamUsageEstimator;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/11 15:12
 */
public class HashMapTest {

    public static void main(String[] args) {
        String world = "yyyy-MM-dd HH:mm:ss".intern();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int begin = 0, end = m * n - 1;
        int mid;
        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            if (matrix[mid / n][mid % n] < target) {
                begin = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    static class A {
        @Override
        public int hashCode() {
            return 39;
        }
    }

}

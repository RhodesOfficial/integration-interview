package com.calpis.interview.algorithm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/11 0:40
 */
public class Test {

    private static final ReadWriteLock rw = new ReentrantReadWriteLock();

    public static void main(String[] args) throws Exception {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    public static boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>((int) (len1 / 0.75) + 1);
        for (int i = 0; i < len1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (char key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        for (int i = 1; i < len1; i++) {
            // S1 -> T1 && S2 -> T2
            boolean b1 = isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i));
            // S1 -> T2 && S2 -> T1
            boolean b2 = isScramble(s1.substring(0, i), s2.substring(len1 - i)) &&
                    isScramble(s1.substring(i), s2.substring(len2 - i));
            if (b1 || b2) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long cur = nums[i];
            Long floor = set.floor(cur);
            if (floor != null && cur - floor <= t) {
                return true;
            }
            Long ceiling = set.ceiling(cur);
            if (ceiling != null && ceiling - cur <= t) {
                return true;
            }
            set.add(cur);
            if (set.size() >= k) {
                // [Math.max(0, i - k), i]
                if (i - k >= 0) {
                    set.remove(nums[i - k]);
                }
            }
        }
        return false;
    }

    public static int nthUglyNumber(int n) {
        int ugly = 0;
        int count = 1;
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (count == n) {
                break;
            }
            if (isUgly(i)) {
                count++;
                ugly = i;
            }
        }
        return ugly;
    }

    public static boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static boolean reorderedPowerOf2(int N) {
        char[] a1 = String.valueOf(N).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);
        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf((1 << i)).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if (s1.equals(s2)) {
                return true;
            }
        }
        return false;
    }

    private static long counter(int N) {
        long res = 0;
        while (N > 0) {
            res += Math.pow(10, N % 10);
            N /= 10;
        }
        return res;
    }

    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(c[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < numRows; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }


}

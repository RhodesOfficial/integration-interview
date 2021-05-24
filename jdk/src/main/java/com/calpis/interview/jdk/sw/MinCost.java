package com.calpis.interview.jdk.sw;

import java.util.Arrays;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/5/4 16:14
 */
public class MinCost {

    private int[] houses;
    private int[][] cost;
    private int m;
    private int n;
    private int target;
    private Integer[][][] cache;

    public static void main(String[] args) {
//        MinCost minCost = new MinCost();
        /*
         * [0,0,0,0,0]
         * [[1,10],[10,1],[10,1],[1,10],[5,1]]
         * 5
         * 2
         * 3
         */
//        int res = minCost.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3);
//        System.out.println(res);
        System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] set = new int[26];
        Arrays.fill(set, -1);
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (set[cur] == -1) {
                set[cur] = i;
            } else {
                res = Math.max(res, i - set[cur] - 1);
            }
        }
        return res;
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        this.cache = new Integer[houses.length + 1][n + 1][target + 1];
        int res = dfs(0, 0, 0, 0) ;
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * idx - 第idx个房子
     * cur - 处理中的房子颜色
     * cnt - 已经形成的分区数量
     * sum - 上色成本
     */
    private int dfs(int idx, int cur, int cnt, int sum) {
        // 剪枝 - 如果分区已经超过target就不用继续了
        if (cnt > target) {
            return Integer.MAX_VALUE;
        }
        // 到达终点
        if (idx == m) {
            // 是否有target个分区
            if (cnt == target) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (cache[idx][cur][cnt] != null) {
            return cache[idx][cur][cnt];
        }
        int color = houses[idx];
        int ans = Integer.MAX_VALUE;
        if (color == 0) {
            // note!!! 题干说了1到n
            for (int i = 1; i <= n; i++) {
                // 上个房子和当前房子颜色做个对比
                int nextCnt = idx - 1 < 0 ? 1 : i == cur ? cnt : cnt + 1;
                int tmp = dfs(idx + 1, i, nextCnt, sum + cost[idx][i - 1]);
                if (tmp == Integer.MAX_VALUE) {
                    continue;
                }
                ans = Math.min(ans, tmp + cost[idx][i - 1]);
            }
        } else {
            int nextCnt = idx - 1 < 0 ? 1 : color == cur ? cnt : cnt + 1;
            int tmp = dfs(idx + 1, color, nextCnt, sum);
            ans = Math.min(ans, tmp);
        }
        cache[idx][cur][cnt] = ans;
        return ans;
    }
}

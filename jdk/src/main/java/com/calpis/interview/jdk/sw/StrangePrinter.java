package com.calpis.interview.jdk.sw;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/5/24 23:28
 */
public class StrangePrinter {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return dfs(s, dp, 0, n - 1);
    }

    private int dfs(String s, int[][] dp, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            dp[start][end] = 1;
            return 1;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        dp[start][end] = dfs(s, dp, start + 1, end) + 1;
        for (int i = start + 1; i <= end; i++) {
            if (s.charAt(i) == s.charAt(start)) {
                dp[start][end] = Math.min(dp[start][end], dfs(s, dp, start + 1, i - 1) + dfs(s, dp, i, end));
            }
        }
        return dp[start][end];
    }
}

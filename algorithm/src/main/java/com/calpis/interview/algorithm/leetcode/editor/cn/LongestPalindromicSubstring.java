//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3205 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;
public class LongestPalindromicSubstring {
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // step1: 定义状态
        // dp[i][j] -> s[i...j]是否为回文串
        // step2: 状态转移方程
        // dp[i][j] = (s[i] == s[j]) && (dp[i + 1][j - 1])
        // 边界条件 [i + 1, j - 1]不构成区间 即 j - i > 3
        // step3: 初始化
        // 对角线一定为回文 dp[k][k] = true
        // step4: 考虑输出
        // 只要dp[i][j]为true就记录子串的长度和初始位置
        // step5: 优化空间 降维打击 (略)
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
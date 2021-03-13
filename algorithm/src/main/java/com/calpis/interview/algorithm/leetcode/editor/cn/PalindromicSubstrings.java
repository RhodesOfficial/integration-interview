//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 507 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;
public class PalindromicSubstrings {
      public static void main(String[] args) {
           Solution solution = new PalindromicSubstrings().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
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
        int ans = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (charArray[i] == charArray[j]) {
                    if (j - i < 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
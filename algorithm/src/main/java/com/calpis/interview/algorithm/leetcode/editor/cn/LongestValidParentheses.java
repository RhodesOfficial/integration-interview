//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1165 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;
public class LongestValidParentheses {
      public static void main(String[] args) {
           Solution solution = new LongestValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public int longestValidParentheses(String s) {
        //  (    )    (    )    (    (    )    )
        //  0    2    0    4    0    0    2  (2+4+2)
        int length = s.length();
        if (length < 2) {
            return 0;
        }
        int longest = 0;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            if (cur == RIGHT) {
                if (i > 0) {
                    int preChar = s.charAt(i - 1);
                    if (preChar == LEFT) {
                        if (i >= 2) {
                            dp[i] = dp[i - 2] + 2;
                        } else {
                            dp[i] = 2;
                        }
                    } else {
                        if (i - dp[i - 1] >= 1) {
                            if (s.charAt(i - dp[i - 1] - 1) == LEFT) {
                                if (i - dp[i - 1] >= 2) {
                                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                                } else {
                                    dp[i] = dp[i - 1] + 2;
                                }
                            }
                        }
                    }
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
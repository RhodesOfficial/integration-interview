//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1559 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final String LEFT = "(";
    private static final String RIGHT = ")";
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        backstack(new StringBuilder(), n, n);
        return res;
    }

    private void backstack(StringBuilder sb, int left, int right) {
        if (left > right) {
            return;
        }
        if (left < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        sb.append(LEFT);
        backstack(sb, left - 1, right);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(RIGHT);
        backstack(sb, left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
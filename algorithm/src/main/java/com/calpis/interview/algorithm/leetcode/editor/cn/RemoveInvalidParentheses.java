//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。 
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。 
//
// 示例 1: 
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 输入: ")("
//输出: [""] 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 379 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.*;

public class RemoveInvalidParentheses {
      public static void main(String[] args) {
           Solution solution = new RemoveInvalidParentheses().new Solution();
          System.out.println(solution.removeInvalidParentheses("(a)())()"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        set.add(s);
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(s);
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 找到答案了
            if (!res.isEmpty()) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    res.add(cur);
                }
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) == '(' || cur.charAt(j) == ')') {
                        String ns = cur.substring(0, j) + cur.substring(j + 1);
                        if (!set.contains(ns)) {
                            set.add(ns);
                            queue.offer(ns);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')'){
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
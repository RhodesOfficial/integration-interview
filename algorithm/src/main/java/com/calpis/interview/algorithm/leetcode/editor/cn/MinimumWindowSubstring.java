//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 964 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
          System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

//          /**
//           * 滑动窗口模板？
//           *
//           * @param s
//           * @param t
//           */
//          void slidingWindow(String s, String t) {
//              Map<Character, Integer> need = new HashMap<>();
//              Map<Character, Integer> window = new HashMap<>();
//              for (char c : t.toCharArray()) {
//                  need.put(c, need.getOrDefault(c, 0) + 1);
//              }
//              int left = 0, right = 0, valid = 0;
//              while (right < s.length()) {
//                  // c是移入窗口的字符
//                  char c = s.charAt(right);
//                  // 右移窗口
//                  right++;
//                  // 进行窗口内数据的一系列更新
//                  // ...
//                  // 判断左窗口是否需要收缩
////            while (window needs shrink) {
////                // d是将要移出窗口的字符
////                char d = s.charAt(left);
////                // 左移窗口
////                left++;
////                // 进行窗口内数据的一系列更新
////            }
//              }
//          }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 489 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
      public static void main(String[] args) {
           Solution solution = new FindAllAnagramsInAString().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
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
        return res;
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
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1128 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<Character, char[]> alphabet;
    private List<String> res;
    private String digits;
    private int length;

    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList<>();
        this.digits = digits;
        if ((this.length = digits.length()) == 0) {
            return res;
        }
        init();
        backtrack(new StringBuilder(), 0);
        return res;
    }

    private void backtrack(StringBuilder sb, int index) {
        if (sb.length() == length) {
            res.add(sb.toString());
            return;
        }
        char[] chars = alphabet.get(digits.charAt(index));
        for (char c : chars) {
            backtrack(sb.append(c), index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void init() {
      this.alphabet = new HashMap<>();
      alphabet.put('2', new char[]{'a', 'b', 'c'});
      alphabet.put('3', new char[]{'d', 'e', 'f'});
      alphabet.put('4', new char[]{'g', 'h', 'i'});
      alphabet.put('5', new char[]{'j', 'k', 'l'});
      alphabet.put('6', new char[]{'m', 'n', 'o'});
      alphabet.put('7', new char[]{'p', 'q', 'r', 's'});
      alphabet.put('8', new char[]{'t', 'u', 'v'});
      alphabet.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
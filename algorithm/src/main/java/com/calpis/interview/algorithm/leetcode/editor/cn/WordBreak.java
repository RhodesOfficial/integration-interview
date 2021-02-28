//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 847 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.*;

public class WordBreak {
      public static void main(String[] args) {
           Solution solution = new WordBreak().new Solution();
          String s = "applepenapple";
          List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
          System.out.println(solution.wordBreak(s, wordDict));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    private String s;
//    private List<String> wordDict;
//    private Map<String, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
//        this.s = s;
//        this.wordDict = wordDict;
//        this.memo = new HashMap<>();
//        return backtrack("");
        // dp[i]=长度为i的s[0, i - 1]字串能否拆分成单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

//    private boolean backtrack(String temp) {
//        if (memo.containsKey(temp)) {
//            return memo.get(temp);
//        }
//        if (temp.length() == s.length()) {
//            return temp.equals(s);
//        }
//        if (temp.length() > s.length()) {
//            return false;
//        }
//        for (int i = 0; i < temp.length(); i++) {
//            if (s.charAt(i) != temp.charAt(i)) {
//                return false;
//            }
//        }
//        for (String value : wordDict) {
//            if (backtrack(temp + value)) {
//                memo.put(temp, true);
//                return true;
//            }
//        }
//        memo.put(temp, false);
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
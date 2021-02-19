//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1137 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] nums;
    private boolean[] used;
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new boolean[nums.length];
        this.res = new ArrayList<>();
        backtrack(new ArrayList<>());
        return res;
    }

    private void backtrack(List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtrack(path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
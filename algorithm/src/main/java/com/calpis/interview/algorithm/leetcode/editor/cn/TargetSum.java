//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 584 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
      public static void main(String[] args) {
           Solution solution = new TargetSum().new Solution();
          System.out.println(solution.findTargetSumWays(new int[]{}, 2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] nums;
    private int target;
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int S) {
        this.nums = nums;
        this.target = S;
        this.memo = new HashMap<>();
        return help(0, 0);
    }

    private int help(int i, int sum) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        String key = i + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = help(i + 1, sum + nums[i]) + help(i + 1, sum - nums[i]);
        memo.put(key, result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
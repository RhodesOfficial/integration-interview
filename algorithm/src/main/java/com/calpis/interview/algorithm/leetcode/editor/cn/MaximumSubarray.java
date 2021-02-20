//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2896 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;
public class MaximumSubarray {
      public static void main(String[] args) {
           Solution solution = new MaximumSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

      private class Status {
          int lSum, rSum, mSum, iSum;

          public Status(int lSum, int rSum, int mSum, int iSum) {
              this.lSum = lSum;
              this.rSum = rSum;
              this.mSum = mSum;
              this.iSum = iSum;
          }
      }

      /*
       * 分治法 todo
       */
      public int maxSubArray(int[] nums) {
          return get(nums, 0, nums.length - 1).mSum;
      }

      /*
       * 查询a序列[l,r]区间内的最大子段和
       */
      private Status get(int[] a, int l, int r) {
          if (l == r) {
              return new Status(a[l], a[l], a[l], a[l]);
          }
          int m = l + (r - l) / 2;
          Status lSub = get(a, l, m);
          Status rSub = get(a, m + 1, r);
          return pushUp(lSub, rSub);
      }

      private Status pushUp(Status l, Status r) {
          int lSum = Math.max(l.lSum, l.iSum + r.lSum);
          int rSum = Math.max(r.rSum, r.iSum + l.rSum);
          int iSum = l.iSum + r.iSum;
          int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
          return new Status(lSum, rSum, mSum, iSum);
      }

//    public int maxSubArray(int[] nums) {
//        int pre = 0, maxRes = nums[0];
//        for (int num : nums) {
//            pre = Math.max(pre + num, num);
//            maxRes = Math.max(pre, maxRes);
//        }
//        return maxRes;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 689 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
      public static void main(String[] args) {
           Solution solution = new LongestConsecutiveSequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>((int) (nums.length / 0.75) + 1);
        for (int num : nums) {
            set.add(num);
        }
        int longestLength = 0;
        int currentNum;
        int currentLength;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                currentNum = num;
                currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }
                longestLength = Math.max(longestLength, currentLength);
            }
        }
        return longestLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
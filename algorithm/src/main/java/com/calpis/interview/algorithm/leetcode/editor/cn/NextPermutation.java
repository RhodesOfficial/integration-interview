//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 946 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;
public class NextPermutation {
      public static void main(String[] args) {
           Solution solution = new NextPermutation().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int index = findNearestIndex(nums);
        if (index == 0) {
            reverse(0, nums);
            return;
        }
        headExchange(index, nums);
        reverse(index, nums);
    }

    private int findNearestIndex(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private void headExchange(int index, int[] nums) {
        int head = nums[index - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (head < nums[i]) {
                nums[index - 1] = nums[index - 1] ^ nums[i];
                nums[i] = nums[index - 1] ^ nums[i];
                nums[index - 1] = nums[index - 1] ^ nums[i];
                break;
            }
        }
    }

    private void reverse(int index, int[] nums) {
        for (int i = index, j = nums.length - 1; i < j; i++, j--) {
            if (nums[i] != nums[j]) {
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
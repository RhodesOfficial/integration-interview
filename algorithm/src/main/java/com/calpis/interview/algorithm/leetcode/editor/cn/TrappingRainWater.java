//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2048 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * todo dp和双指针待完善
 */
public class TrappingRainWater {
      public static void main(String[] args) {
           Solution solution = new TrappingRainWater().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*
     * 暴力
     */
//    public int trap(int[] height) {
//        int ans = 0;
//        for (int i = 0; i < height.length; i++) {
//            int maxLeft = 0, maxRight = 0;
//            for (int j = i; j >= 0; j--) {
//                maxLeft = Math.max(height[j], maxLeft);
//            }
//            for (int j = i; j < height.length; j++) {
//                maxRight = Math.max(height[j], maxRight);
//            }
//            ans += Math.min(maxLeft, maxRight) - height[i];
//        }
//        return ans;
//    }

    /*
     * 单调栈
     */
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 从左往右,左比右低就能接到雨水
        for (int i = 0; i < height.length; i++) {
            // 当出现高于栈顶的柱子时,说明可以对前面的柱子结算了
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // bottom -> stack.pop()
                // left -> 新的栈顶
                // right -> i
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int right = i;
                // height = Math.min(left, right) - bottom
                int h = Math.min(height[left], height[right]) - height[bottom];
                int w = right - left - 1;
                ans += h * w;
            }
            // 对更低的柱子入栈
            stack.push(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
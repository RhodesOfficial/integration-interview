//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1202 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
      public static void main(String[] args) {
           Solution solution = new LargestRectangleInHistogram().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                while (!stack.isEmpty() && height == heights[stack.peek()]) {
                    stack.pop();
                }
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            while (!stack.isEmpty() && height == heights[stack.peek()]) {
                stack.pop();
            }
            int width = stack.isEmpty() ? len : len - stack.peek() - 1;
            area = Math.max(area, height * width);
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
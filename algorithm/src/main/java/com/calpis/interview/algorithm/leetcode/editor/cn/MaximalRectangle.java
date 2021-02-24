//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 823 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
      public static void main(String[] args) {
           Solution solution = new MaximalRectangle().new Solution();
           char[][] matrix = {
                   {'1','0','1','0','0'},
                   {'1','0','1','1','1'},
                   {'1','1','1','1','1'},
                   {'1','0','0','1','0'}};
           solution.maximalRectangle(matrix);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int area = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heights[j] = (matrix[i][j] == '0') ? 0 : heights[j] + 1;
            }
            area = Math.max(area, largestRectangleArea(heights));
        }
        return area;
    }

    private int largestRectangleArea(int[] heights) {
        int area = 0;
        int len = heights.length;
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
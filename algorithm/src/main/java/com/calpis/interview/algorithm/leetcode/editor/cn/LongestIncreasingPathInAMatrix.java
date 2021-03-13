//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化 
// 👍 433 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;
public class LongestIncreasingPathInAMatrix {
      public static void main(String[] args) {
           Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int row;
    private int col;
    private int[][] matrix;
    private int[][] dp;
    private int max;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = matrix;
        this.dp = new int[row][col];
        this.max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(Integer.MIN_VALUE, i, j));
            }
        }
        return max;
    }

    private int dfs(int pre, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || matrix[i][j] <= pre) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 0;
        max = Math.max(max, dfs(matrix[i][j], i + 1, j));
        max = Math.max(max, dfs(matrix[i][j], i - 1, j));
        max = Math.max(max, dfs(matrix[i][j], i, j + 1));
        max = Math.max(max, dfs(matrix[i][j], i, j - 1));
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
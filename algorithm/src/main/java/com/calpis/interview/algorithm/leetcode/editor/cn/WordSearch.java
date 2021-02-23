//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 790 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;
public class WordSearch {
      public static void main(String[] args) {
           Solution solution = new WordSearch().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[][] offset = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[][] board;
    private String word;
    private int row;
    private int col;
    private boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.row = board.length;
        this.col = board[0].length;
        this.marked = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int start) {
        if (start == word.length() - 1) {
            return board[x][y] == word.charAt(start);
        }
        if (board[x][y] == word.charAt(start)) {
            marked[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int newX = x + offset[k][0];
                int newY = y + offset[k][1];
                if (isArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[x][y] = false;
        }
        return false;
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
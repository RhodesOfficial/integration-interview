//在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。 
//
// 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两
//个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。 
//
// 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？ 
//
// 
//
// 示例 1: 
//
// 
//输入: [[0,2],[1,3]]
//输出: 3
//解释:
//时间为0时，你位于坐标方格的位置为 (0, 0)。
//此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
//
//等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
// 
//
// 示例2: 
//
// 
//输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6
//]]
//输出: 16
//解释:
// 0  1  2  3  4
//24 23 22 21  5
//12 13 14 15 16
//11 17 18 19 20
//10  9  8  7  6
//
//最终的路线用加粗进行了标记。
//我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
// 
//
// 
//
// 提示: 
//
// 
// 2 <= N <= 50. 
// grid[i][j] 是 [0, ..., N*N - 1] 的排列。 
// 
// Related Topics 堆 深度优先搜索 并查集 二分查找 
// 👍 164 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SwimInRisingWater {
      public static void main(String[] args) {
           Solution solution = new SwimInRisingWater().new Solution();
          System.out.println(solution.swimInWater(new int[][]{{0, 2}, {1, 3}}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * m + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.max(grid[i - 1][j], grid[i][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.max(grid[i][j - 1], grid[i][j])});
                }
            }
        }
        edges.sort(Comparator.comparing(o -> o[2]));
        UnionFind unionFind = new UnionFind(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], z = edge[2];
            unionFind.union(x, y);
            if (unionFind.isConnected(0, m * n - 1)) {
                ans = z;
                break;
            }
        }
        return ans;
    }

          private class UnionFind {

              private int[] parent;

              public UnionFind(int n) {
                  this.parent = new int[n];
                  for (int i = 0; i < n; i++) {
                      parent[i] = i;
                  }
              }

              public int find(int p) {
                  if (parent[p] != p) {
                      parent[p] = find(parent[p]);
                  }
                  return parent[p];
              }

              public void union(int p, int q) {
                  int pId = find(p);
                  int qId = find(q);
                  parent[pId] = qId;
              }

              public boolean isConnected(int p, int q) {
                  return find(p) == find(q);
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

}
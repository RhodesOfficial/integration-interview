//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values
//[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], quer
//ies = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a
//","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
// Related Topics 并查集 图 
// 👍 488 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// todo https://leetcode-cn.com/problems/evaluate-division/solution/399-chu-fa-qiu-zhi-nan-du-zhong-deng-286-w45d/
public class EvaluateDivision {
      public static void main(String[] args) {
           Solution solution = new EvaluateDivision().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

      public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
          // 等式数量
          int equationSize = equations.size();
          // 每个等式有2个变量
          UnionFind unionFind = new UnionFind(equationSize << 1);

          Map<String, Integer> hashMap = new HashMap<>(equationSize << 1);
          int id = 0;
          for (int i = 0; i < equationSize; i++) {
              List<String> equation = equations.get(i);
              String a = equation.get(0);
              String b = equation.get(1);
              if (!hashMap.containsKey(a)) {
                  hashMap.put(a, id++);
              }
              if (!hashMap.containsKey(b)) {
                  hashMap.put(b, id++);
              }
              unionFind.union(hashMap.get(a), hashMap.get(b), values[i]);
          }

          int queriesSize = queries.size();
          double[] res = new double[queriesSize];
          for (int i = 0; i < queriesSize; i++) {
              String a = queries.get(i).get(0);
              String b = queries.get(i).get(1);
              Integer id1 = hashMap.get(a);
              Integer id2 = hashMap.get(b);
              if (id1 == null || id2 == null) {
                  res[i] = -1.0d;
              } else {
                  res[i] = unionFind.isConnected(id1, id2);
              }
          }

          return res;
      }

      private class UnionFind {

          private int[] parent;
          private double[] weight;

          public UnionFind(int n) {
              this.parent = new int[n];
              this.weight = new double[n];
              for (int i = 0; i < n; i++) {
                  parent[i] = i;
                  weight[i] = 1.0d;
              }
          }

          public int find(int p) {
              if (parent[p] != p) {
                  int origin = parent[p];
                  parent[p] = find(parent[p]);
                  weight[p] *= weight[origin];
              }
              return parent[p];
          }

          public void union(int p, int q, double value) {
              int pId = find(p);
              int qId = find(q);
              if (pId == qId) {
                  return;
              }
              parent[pId] = qId;
              // weight[p] * weight[pId] = weight[q] * value
              weight[pId] = weight[q] * value / weight[p];
          }

          public double isConnected(int p, int q) {
              return find(p) == find(q) ? weight[p] / weight[q] : -1.0d;
          }

      }

}
//leetcode submit region end(Prohibit modification and deletion)

}
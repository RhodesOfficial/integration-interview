//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 784 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import com.calpis.interview.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        this.res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        recursion(root, 0);
        return res;
    }

    private void recursion(TreeNode treeNode, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(treeNode.val);
        if (treeNode.left != null) {
            recursion(treeNode.left, level + 1);
        }
        if (treeNode.right != null) {
            recursion(treeNode.right, level + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
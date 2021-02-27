//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 890 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import com.calpis.interview.algorithm.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

    private final Map<Integer, Integer> memo = new HashMap<>();

    // todo 好难
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 先序找根
        TreeNode root = new TreeNode(preorder[0]);
        // 划分左右
        int idx = index(inorder, preorder[0]);
        // 递归
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, idx + 1, preorder.length), Arrays.copyOfRange(inorder, idx + 1, inorder.length));
        return root;
    }

    private int index(int[] arr, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int idx = 0;
        while (arr[idx] != i) {
            idx++;
        }
//        return idx;
        memo.put(i, idx);
        return idx;
    }

//    /*
//     * 只要我们在中序遍历中定位到根节点
//     * 那么我们就可以分别知道左子树和右子树中的节点数目
//     */
//    private TreeNode buildTree(int preorderFirst, int preorderLast, int inorderFirst, int inorderLast) {
//        // 前序遍历中的第一个节点就是根节点 根节点的值
//        int rootVal = preorder[preorderFirst];
//        // 建立根节点
//        TreeNode treeNode = new TreeNode(rootVal);
//        // 通过中序遍历定位到根节点
//        int point = inorderFirst;
//        while (inorder[point] != rootVal) {
//            point++;
//        }
//        // 左长度
//        int leftLength = point - inorderFirst;
//        // 右长度
//        int rightLength = inorderLast - point;
//        if (leftLength > 0) {
//            // 先序遍历中从左边界+1开始的leftLength个元素
//            // 对应了中序遍历中的从左边界开始到根节点定位-1个元素
//            treeNode.left = buildTree(
//                    preorderFirst + 1,
//                    preorderFirst + leftLength,
//                    inorderFirst,
//                    inorderFirst + leftLength - 1);
//        }
//        if (rightLength > 0) {
//            // 先序遍历中从左边界+1开始的leftLength个元素
//            // 对应了中序遍历中的从根节点定位+1开始到有边界个元素
//            treeNode.right = buildTree(
//                    preorderFirst + rightLength + 1,
//                    preorderLast,
//                    inorderFirst + 1,
//                    inorderLast);
//        }
//        return treeNode;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
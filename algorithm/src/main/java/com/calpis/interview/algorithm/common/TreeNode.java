package com.calpis.interview.algorithm.common;

/**
 * @author Zhujialiang
 * @version V1.0
 * @Description
 * @Date 2021/2/24 18:03
 * @Copyright Copyright © 2020 深圳花儿绽放网络科技股份有限公司. All rights reserved.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

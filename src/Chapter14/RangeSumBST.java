/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter14;

/**
 * No.938 二叉搜索树的范围和
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 题目很简单，除了这种解法，还可以把中序遍历的结果得到，然后再求数组的范围和。
 */
public class RangeSumBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)),
        new TreeNode(15, new TreeNode(13), new TreeNode(18)));

    System.out.println(rangeSumBST(root, 6, 10));
  }

  public static int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    if (low > root.val) {
      return rangeSumBST(root.right, low, high);
    } else if (high < root.val) {
      return rangeSumBST(root.left, low, high);
    } else {
      return root.val + rangeSumBST(root.left, low, root.val) + rangeSumBST(root.right, root.val, high);
    }
  }

}

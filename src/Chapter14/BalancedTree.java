/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter14;

/**
 * No.110 平衡二叉树
 */
public class BalancedTree {

  public boolean isBalanced(TreeNode root) {
    return maxDepth(root) != -1;
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left), right = maxDepth(root.right);
    if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }
}

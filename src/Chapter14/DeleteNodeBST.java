/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter14;

/**
 * No. 450 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
public class DeleteNodeBST {

  public TreeNode deleteNode(TreeNode root, int key) {
    return dfs(root, key);
  }

  public TreeNode dfs(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    // 分为三种情况：
    // 1. root的值等于key，那么要删除root节点
    if (root.val == key) {
      // 1.1 如果root是叶子节点，那么直接删除
      if (root.left == null && root.right == null) {
        root = null;
        // 1.2 如果root左节点是空
      } else if (root.left == null) {
        root = root.right;
        //1.3 如果root右节点是空
      } else if (root.right == null) {
        root = root.left;
        // 1.4 如果左右节点都不是空，那么左节点应重新接在右节点的最左边节点的左节点
        // 因为左节点小于右子树中最小的那个数
      } else {
        TreeNode left = root.left;
        root = root.right;
        TreeNode right = root;
        while (right.left != null) {
          right = right.left;
        }
        right.left = left;
      }
      // 2. 如果root的值小于key，那么要删除的节点在root的右边，左子树不变
    } else if (root.val < key) {
      root.right = dfs(root.right, key);
      // 3. 如果root的值大于key，那么要删除的节点在root的左边，右子树不变
    } else {
      root.left = dfs(root.left, key);
    }
    return root;
  }

}

/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * No.530 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 * 二叉搜索树的中序遍历是一个递增的数组，那么此题很容易转换成该递增数组相邻两数的最小差值
 */
public class MinimumDifference {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
    System.out.println(getMinimumDifference(root));
  }

  public static int getMinimumDifference(TreeNode root) {
    List<Integer> nums = new ArrayList<>();
    inorder(root, nums);

    int minValue = Integer.MAX_VALUE;
    for (int i = 0; i < nums.size() - 1; i++) {
      minValue = Math.min(minValue, nums.get(i+1) - nums.get(i));
    }
    return minValue;
  }

  public static void inorder(TreeNode root, List<Integer> nums) {
    if (root == null) {
      return;
    }

    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
  }
}

/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No.872 叶子相似的树
 *
 * 两棵树如果叶子结点的序列值一样，那么就返回true，否则返回false
 */
public class LeafSimilar {
  public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
    Deque<TreeNode> deque1 = new ArrayDeque<>();
    Deque<TreeNode> deque2 = new ArrayDeque<>();
    List<Integer> res1 = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();
    leafNodes(root1, deque1, res1);
    leafNodes(root2, deque2, res2);

    if (res1.size() != res2.size()) {
      return false;
    } else {
      for (int i = 0; i < res1.size(); i++) {
        if (!res1.get(i).equals(res2.get(i))) {
          return false;
        }
      }
    }
    return true;
  }

  public static void leafNodes(TreeNode root, Deque<TreeNode> queue, List<Integer> res) {
    while (!queue.isEmpty() || root != null) {
      while (root != null) {
        queue.push(root);
        root = root.left;
      }

      TreeNode node = queue.pop();
      if (node.left == null && node.right == null) {
        res.add(node.val);
      } else {
        root = node.right;
      }
    }
  }
}

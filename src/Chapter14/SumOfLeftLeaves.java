/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter14;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No. 404 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    System.out.println(sumOfLeftLeavs(root));
  }

  // 方法一： 深度遍历
  public static int sumOfLeftLeavs(TreeNode root) {
    return dfs(root);
  }

  public static int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int count = 0;

    // 判断root.left是否叶子节点
    if (root.left != null && root.left.left == null && root.left.right == null) {
      count = root.left.val;
    }

    count += dfs(root.left);
    count += dfs(root.right);
    return count;

  }

  // 方法二：广度遍历
  public static int method2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    int ans = 0;
    queue.offer(root);
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          // 如果左节点是叶子结点，就把值加入到ans中
          // 如果左节点不是叶子结点，就加入到queue中
          if (isLeafNode(node.left)) {
            ans += node.left.val;
          } else {
            queue.offer(node.left);
          }
        }
        // 如果右节点是叶子结点，则不必处理
        // 如果不是叶子节点则加入到queue中继续判断
        if (node.right != null && !isLeafNode(node.right)) {
          queue.offer(node.right);
        }
      }
    }
    return ans;

  }

  public static boolean isLeafNode(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}


package Chapter14;

/**
 * No.110 平衡二叉树
 *
 * 判断一个二叉树是否平衡。树平衡的定义是，对于树上的任意节点，其两侧节点的最大深度的差值不得大于1。
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

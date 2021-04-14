
package Chapter14;

/**
 * No. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点
 *
 * 所以需要求出每个结点的左子树的深度 + 右子树的深度，然后取最大值
 */
public class DiameterOfBinaryTree {

  int maxSize = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    maxDepth(root);
    return maxSize;
  }

  // 返回值是每个结点的深度
  public int maxDepth(TreeNode root) {
    if (root.left == null && root.right == null) {
      return 0;
    }

    int leftSize = root.left == null ? 0 : maxDepth(root.left) + 1;
    int rightSize = root.right == null ? 0 : maxDepth(root.right) + 1;
    // 用一个全局变量保存最长路径
    maxSize = Math.max(maxSize, leftSize + rightSize);
    return Math.max(leftSize, rightSize);
  }

}

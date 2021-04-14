
package Chapter14;

/**
 * No.101 对称二叉树
 *
 * 给定一个二叉树，判断他们是否是镜像对称的
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 注意：并不是要求一个节点下的两个子节点值相同
 */
public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    return root == null || helper(root.left, root.right);
  }

  public boolean helper(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    // 如果两个节点的值不相等，那么可以直接返回false
    // 但是两个节点的值相等并不能立马返回true，只能再继续判断它们的子节点，一直到没有子节点为止
    if (left.val != right.val) {
      return false;
    }

    // 下一层
    return helper(left.left, right.right) && helper(right.left, left.right);
  }

}

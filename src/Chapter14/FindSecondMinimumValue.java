
package Chapter14;

/**
 * No. 671 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 */
public class FindSecondMinimumValue {

  public static void main(String[] args) {
    //TreeNode root = new TreeNode(2, new TreeNode(2, new TreeNode(2), new TreeNode(2)), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
    TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
    System.out.println(findSecondMinimumValue(root));
  }

  public static int findSecondMinimumValue(TreeNode root) {
    if (root == null || root.left == null) {
      return -1;
    }

    if (root.left.val > root.val) {
      int temp = findSecondMinimumValue(root.right);
      if (temp > root.left.val || temp == -1) {
        return root.left.val;
      } else {
        return temp;
      }
    } else if (root.right.val > root.val) {
      int temp = findSecondMinimumValue(root.left);
      if (temp > root.right.val || temp == -1) {
        return root.right.val;
      } else {
        return temp;
      }
    } else {
      int left = findSecondMinimumValue(root.left);
      int right = findSecondMinimumValue(root.right);
      if (left == -1 && right == -1) {
        return -1;
      } else if (left != -1 && right != -1) {
        return Math.min(left, right);
      } else {
        return left == -1 ? right : left;
      }
    }
  }

}

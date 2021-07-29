
package Chapter14;

/**
 * No. 671 二叉树中第二小的节点
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

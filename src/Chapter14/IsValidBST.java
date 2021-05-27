package Chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * No.98 验证二叉搜索树
 *
 * 判断是否是有效二叉搜索数。常规：中序遍历
 */
public class IsValidBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
    System.out.println(isValidBST(root));
  }

  public static boolean isValidBST(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    for (int i = 1; i < res.size(); i++) {
      if (res.get(i) <= res.get(i-1)) {
        return false;
      }
    }
    return true;
  }

  public static void inorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inorder(root.left, res);
    res.add(root.val);
    inorder(root.right, res);
  }

}

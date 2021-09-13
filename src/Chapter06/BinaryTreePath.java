
package Chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * No.257 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class BinaryTreePath {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(binaryTreePaths(root));
  }

  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    dfs(root, res, "");
    return res;
  }

  public static void dfs(TreeNode root, List<String> res, String path) {
    path = path + root.val;
    if (root.left == null && root.right == null) {
      res.add(path);
      return;
    }

    path = path + "->";
    if (root.left != null) {
      dfs(root.left, res, path);
    }
    if (root.right != null) {
      dfs(root.right, res, path);
    }
  }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
  }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

}




package Chapter14;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.538 把二叉搜索树转换为累加树
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 首先想到的是反中序遍历
 * 可以用递归也可以用栈
 */
public class ConvertBST {
  static int sum = 0;

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    root = convertBST(root);
    System.out.println(root.val);
    System.out.println(root.left.val);
    System.out.println(root.right.val);
  }

  // 右、根、左的遍历方式
  public static TreeNode convertBST(TreeNode root) {
    dfs(root,0);
    return root;
  }

  // 递归的写法，psum需作为返回值，或者设置为全局变量，因为psum要累加
  public static int dfs(TreeNode root, int psum) {
    if (root == null) {
      return psum;
    }

    root.val += dfs(root.right, psum);
    return dfs(root.left, root.val);
  }

  // 右、根、左的遍历方式
  public TreeNode convertBST2(TreeNode root) {
    if (root != null) {
      convertBST2(root.right);
      sum += root.val;
      root.val = sum;
      convertBST2(root.left);
    }
    return root;
  }

  // 用栈的写法
  public TreeNode method2(TreeNode root) {
    if (root == null) {
      return null;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    int psum = 0;
    TreeNode curr = root;
    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.right;
      }
      curr = stack.pop();
      curr.val = curr.val + psum;
      psum = curr.val;
      curr = curr.left;
    }
    return root;
  }

}

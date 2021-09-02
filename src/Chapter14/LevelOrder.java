
package Chapter14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.102 二叉树的层序遍历
 *
 * 常规广度优先搜索
 */
public class LevelOrder {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    levelOrder(root);
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    queue.offer(root);
    List<Integer> t = new ArrayList<>();
    t.add(root.val);
    res.add(t);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        if (node.left != null) {
          queue.offer(node.left);
          temp.add(node.left.val);
        }
        if (node.right != null) {
          queue.offer(node.right);
          temp.add(node.right.val);
        }
      }
      if (temp.size() != 0) {
        res.add(temp);
      }

    }
    return res;
  }

}

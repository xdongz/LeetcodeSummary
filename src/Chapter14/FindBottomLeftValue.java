
package Chapter14;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.513 找树左下角的值
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值
 *
 * 首先想到的便是广度遍历。但因为要找最左边的值，便先把右子树的值放入队列
 * 最后一个从队列中poll出来的值便是所求
 */
public class FindBottomLeftValue {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
        new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));

    System.out.println(findBottomLeftValue(root));
  }

  public static int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode node = new TreeNode(0);
    queue.offer(root);
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        node = queue.poll();
        if (node.right != null) {
          queue.offer(node.right);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
      }
    }
    return node.val;
  }

}

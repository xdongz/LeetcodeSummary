
package Chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * No. 653 两数之和IV - 输入BST
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 利用BST的性质，中序遍历是增序，所以就是求递增序列中有没有和为target的两个元素
 */
public class FindTarget {

  public boolean findTarget(TreeNode root, int k) {
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    if (k < res.get(0) + res.get(0) || k > res.get(res.size() - 1)  + res.get(res.size() - 1)) {
      return false;
    }
    for (int left = 0, right = res.size() - 1; left < right;) {
      if (res.get(left) + res.get(right) == k) {
        return true;
      } else if (res.get(left) + res.get(right) < k) {
        left ++;
      } else {
        right --;
      }
    }
    return false;
  }

  public void inorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }

    inorder(root.left, res);
    res.add(root.val);
    inorder(root.right, res);
  }

}

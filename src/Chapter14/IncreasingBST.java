
package Chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * No. 897 递增顺序查找树
 *
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * BST的中序遍历便是递增
 */
public class IncreasingBST {
  public TreeNode increasingBST(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    // 设置一个dummy结点便好做一些
    TreeNode ans = new TreeNode(0), cur = ans;

    for (int var : res) {
      // 下一个结点是它的右结点
      cur.right = new TreeNode(var);
      cur = cur.right;
    }
    return ans.right;
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

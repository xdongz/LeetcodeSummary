
package Chapter14;

/**
 * No. 235 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。

 */
public class LowestCommonAncestor {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0),
        new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
    TreeNode p = new TreeNode(4);
    TreeNode q = new TreeNode(9);

    TreeNode ans = lowestCommonAncestor(root, p, q);
    System.out.println(ans.val);
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    // 如果root结点的值在p和q之间，那么即为要找的结点
    if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)) {
      return root;
    } else if (root.val < p.val) {
      // 如果root 结点的值小于p和q的值，那么继续在root的右子树中寻找
      root = lowestCommonAncestor(root.right, p, q);
    } else {
      // 如果root 结点的值大于p和q的值，那么继续在root的左子树中寻找
      root = lowestCommonAncestor(root.left, p, q);
    }
    return root;
  }

}

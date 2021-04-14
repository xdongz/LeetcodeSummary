
package Chapter14;

/**
 * No.617 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 *
 */
public class MergeTrees {

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = null;
    TreeNode res = mergeTrees(t1, t2);
    System.out.println(res.val);
  }
  public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    TreeNode res = merge(t1, t2);
    return res;
  }

  public static TreeNode merge(TreeNode t1, TreeNode t2) {
    if (t1 != null && t2 != null) {
      t1.val = t1.val + t2.val;
      t1.left = merge(t1.left, t2.left);
      t1.right = merge(t1.right, t2.right);
    } else {
      t1 = t1 == null ? t2 : t1;
    }
    return t1;
  }

}


package Chapter14;

/**
 * No. 572 另一个树的子树
 *
 * 给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 这道题还有其他解法，首先掌握递归，其他解法日后再看
 */
public class Subtree {

  public static void main(String[] args) {
    //TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
    //TreeNode t = new TreeNode(6, new TreeNode(1), new TreeNode(2));
    TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5, new TreeNode(2), null));
    TreeNode t = new TreeNode(3, new TreeNode(1), new TreeNode(2));
    System.out.println(isSubtree(s, t));
  }

  /**
   * 首先想到的方法便是递归
   * 但是需要注意的是，如果两个结点的值一开始就不相等，需继续比较s的左节点和t以及s的右节点和t
   * 可是如果两个结点的值相等之后，要么从这个结点开始就和t一样，要么可能是这个结点的子节点和t一样，或者t不是子树
   *
   * 所以解决这种问题比较好的方法是双重递归，这样可以遍历到s的每个子节点
   */
  public static boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) {
      return false;
    }
    return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public static boolean dfs(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }

    if (s == null || t == null || s.val != t.val) {
      return false;
    }

    return dfs(s.left, t.left) && dfs(s.right, t.right);
  }

}

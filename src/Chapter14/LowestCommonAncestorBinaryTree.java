package Chapter14;

import java.util.*;

/**
 * No.236 二叉树的最近公共祖先
 *
 * 这道题与235不同的是，这是一个普通的二叉树
 */
public class LowestCommonAncestorBinaryTree {
    // map存储着子节点和对应的父节点
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        // 把从p出发一直到根节点经过的结点的值存入visited中
        while (p != null) {
           visited.add(p.val);
           p = parent.get(p);
        }
        // 如果从q出发，经过的根节点的值已经在visited里了，那么就说明这是最近公共祖先
        while (parent.get(q) != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q);
        }
        return q;
    }

    // 把所有结点和对应的父节点存入图中
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
    }

}

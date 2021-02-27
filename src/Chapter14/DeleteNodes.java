package Chapter14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * No.1110 删除结点
 *
 * 给定一个整数二叉树和一些整数，求删掉这些整数对应的节点后，剩余的子树。
 */
public class DeleteNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delSet = new HashSet<>();
        //把待删的结点放入set中
        for (int i : to_delete) {
            delSet.add(i);
        }
        List<TreeNode> res = new ArrayList<>();
        dfs(root, delSet, res);
        // 最上层的不需删除的结点
        if (!delSet.contains(root.val)) {
            res.add(root);
        }
        return res;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> delSet, List<TreeNode> res) {
        if (root == null) {
            return root;
        }

        // 先处理好左右结点，然后再处理root结点
        // 因为如果root结点需要被删除的话，会被置成null
        root.left = dfs(root.left, delSet, res);
        root.right = dfs(root.right, delSet, res);

        // 注意：不需要判断delSet不包含root.val的情况
        // 因为需要由最上层的不需删除的结点加入进res中，否则在res里会有很多结点
        if (delSet.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }

            if (root.right != null) {
                res.add(root.right);
            }
            //待删结点需被置为null
            root = null;
        }
        return root;
    }

}

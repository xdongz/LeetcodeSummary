package Chapter14;

/**
 * No. 669 修建二叉树
 *
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 递归终止条件
        if (root == null) {
            return null;
        }
        // 如果root的值小于low，那么root以及左子树都应全部被删除
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 如果root的值大于high，那么root以及右子树都应全部被删除
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // 如果是在这两者之间，那么再依次递归左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}

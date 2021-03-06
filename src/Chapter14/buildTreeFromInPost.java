package Chapter14;

/**
 * No.106 中序与后序遍历序列构造二叉树
 *
 * 这道题应与No.105 和No.889一起看
 */
public class buildTreeFromInPost {
    public static void main(String[] args) {
        int[] inorder = {1,2,3,4};
        int[] postorder = {4,3,2,1};
        TreeNode root = buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return recover(inorder, postorder, postorder.length - 1, 0, postorder.length);
    }

    // rootIndex是在postorder中根节点的索引
    // len是子树的长度
    public static TreeNode recover(int[] inorder, int[] postorder, int rootIndex, int startIndex, int len) {
        if (len == 0) {
            return null;
        }
        int rootValue = postorder[rootIndex];
        TreeNode root = new TreeNode(rootValue);
        if (len == 1) {
            return root;
        }
        // 左子树的长度
        int L = 1;
        for (int i = 0; i < len; i++) {
           if (inorder[startIndex + i] == rootValue) {
               L = i;
               break;
           }
        }
        // 右子树的长度
        int R = len - L - 1;

        root.left = recover(inorder, postorder, rootIndex - R - 1, startIndex, L);
        root.right = recover(inorder, postorder, rootIndex - 1, startIndex + L + 1, R);
        return root;
    }
}

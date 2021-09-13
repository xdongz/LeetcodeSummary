package Chapter14;

/**
 * No.889 根据前序和后序遍历构造二叉树
 *
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 *
 *  pre 和 post 遍历中的值是不同的正整数。
 */
public class ConstructFromPrePost {

    public static TreeNode constructFromPrePost(int[] pre, int [] post) {
        return recover(pre, post, 0, 0, pre.length);
    }

    // rootIndex代表pre数组中跟结点的索引
    // startIndex代表子树在post数组中开始的起点
    // len代表子树的长度
    public static TreeNode recover(int[] pre, int[] post, int rootIndex, int startIndex, int len) {
        if (len <= 0) {
            return null;
        }
        int rootValue = pre[rootIndex];
        TreeNode root = new TreeNode(rootValue);
        if (len == 1) {
            return root;
        }
        // 左子树的长度
        int L = 1;
        for(; L < len; L++) {
            if (post[startIndex + L - 1] == pre[rootIndex + 1]) {
                break;
            }
        }

        root.left = recover(pre, post, rootIndex + 1, startIndex, L);
        root.right = recover(pre, post, rootIndex + L + 1, startIndex + L, len - L - 1);
        return root;
    }
}

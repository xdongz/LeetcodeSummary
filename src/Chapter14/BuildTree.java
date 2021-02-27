package Chapter14;

import java.util.HashMap;
import java.util.Map;

/**
 * No.105 从前序遍历与中序遍历序列构造二叉树
 *
 * 前序遍历的第一个结点就是根节点，由此找到对应的中序遍历中的索引，索引左边的极为左子树，右边的为右子树
 * 然后分别递归左节点和右结点，并更新他们在前序遍历和中序遍历中开始结束的索引
 * 递归结束的条件是子树的长度小于0
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] preoder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preoder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // key是inorder的的元素，value是对应的索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public static TreeNode helper(int[] preorder, Map<Integer, Integer> map, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        // 如果结束的索引大于开始的索引，说明这个子树是空
        if (preorder_right < preorder_left) {
            return null;
        }
        // 得到根节点在中序遍历中的索引，那么索引的左边就是左子树，右边就是右子树
        // 由此得到左右子树的长度
        int inorder_root = map.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        // 左子树的长度：
        int leftLen = inorder_root - inorder_left;

        // 更新左右子树
        root.left = helper(preorder, map, preorder_left + 1, preorder_left + leftLen, inorder_left, inorder_root - 1);
        root.right = helper(preorder, map, preorder_left + leftLen + 1, preorder_right,inorder_root + 1, inorder_right);
        return root;
    }
}

package Chapter14;

import java.util.*;

/**
 * No. 145 二叉树的后序遍历
 *
 * 用栈实现
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(Arrays.toString(postorderTraversal(root).toArray()));
    }

    // 方法一：先把左结点都加进去，然后再看栈顶元素是否有右子树
    // 如果有右子树，就把栈顶元素重新push回去，再添加右子树的根节点
    // 如果没有右子树了，就把值加到res中
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果该子树的右结点已经被添加进list了，那么该结点也可以被添加进去
            if (root.right == null || root.right == prev) {
                prev = root;
                res.add(root.val);
                // 如果该结点的值被加入list了，要把root结点置为null，避免重复添加该结点的子树
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    // 方法二：根，右，左
    public static List<Integer> method2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root != null) {
            stack.push(root);
        }
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            // 如果栈顶元素是叶子结点，可以弹出并加入到list中
            if (root.left == null && root.right == null) {
                prev = stack.pop();
                res.add(root.val);
                // 如果栈顶元素的左右子树已经被加入list了，那么该元素也可弹出并加入到list中
            } else if (prev != null && (root.right == prev || root.left == prev)) {
                prev = stack.pop();
                res.add(root.val);
            } else {
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
            root = stack.peek();
        }
        return res;
    }
}

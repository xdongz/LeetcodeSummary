package Chapter14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Flatten {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || node != null) {
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                TreeNode left = node.left;
                node.right = left;
                node.left = null;
                node = left;
            } else {
                node.right = stack.pollFirst();
                node = node.right;
            }
        }

    }

    public static void helper(TreeNode root, Deque<TreeNode> stack) {

    }
}

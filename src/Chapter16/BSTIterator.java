package Chapter16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * No. 173 二叉搜索树迭代器
 *
 * 其实就是考虑二叉树的中序遍历
 * 如果不用迭代器，也可以用数组或者队列来实现
 */
public class BSTIterator {
    TreeNode root;
    List<Integer> vals;
    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        this.root = root;
        vals = new ArrayList<>();
        inorder(root, vals);
        iterator = vals.iterator();
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

package Chapter14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * No. 99 恢复二叉搜索树
 *
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 二叉查找树（Binary Search Tree, BST）是一种特殊的二叉树：对于每个父节点，其左子节点的值小于等于父结点的值，其右子节点的值大于等于父结点的值
 *
 * 所以对于二叉搜索树，其中序遍历的结果一定是增序的。此题也是通过判断中序遍历的结果来找到被错误交换的两个结点的值
 */
public class RecoverTree {
    /**
     * 方法一： 先将中序遍历的结果存入到数组中，然后再在数组中查找不符合的两个结点的值，最后递归交换
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<Integer> inorderNum = new ArrayList<>();
        inorder(root, inorderNum);
        int[] swappedNums = findSwappedNums(inorderNum);
        recover(root, 2, swappedNums[0], swappedNums[1]);
    }

    // 得到中序遍历之后的结果
    public void inorder(TreeNode root, List<Integer> inorderNum) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorderNum);
        inorderNum.add(root.val);
        inorder(root.right, inorderNum);
    }

    // 找到被交换的两个数
    public int[] findSwappedNums(List<Integer> inorderNum) {
        int x = 0, y = 0, count = 0;
        for (int i = 0; i < inorderNum.size() - 1; i++) {
           if (inorderNum.get(i + 1) < inorderNum.get(i)) {
               x = inorderNum.get(i + 1);
           }
           if (count == 0 && inorderNum.get(i + 1) < inorderNum.get(i)) {
               count ++;
               y = inorderNum.get(i);
           }
        }
        return new int[] {x, y};
    }

    // 复原二叉树
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (count == 0) {
                return;
            }
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                count--;
            }
            recover(root.left, count, x, y);
            recover(root.right, count,  x, y);
        }
    }

    /**
     * 方法二：我们可以在中序遍历的时候就找到要交换的两个结点
     * 注意中序遍历用栈的实现方式
     *
     */
    public void method2(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val < prev.val) {
                y = root;
                if (x == null) {
                    x = prev;
                }
            }
            prev = root;
            root = root.right;
        }
        swap(x, y);
    }
    public void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

}

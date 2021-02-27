package Chapter14;

import java.util.*;

/**
 * No.637 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 首先想到的就是广度优先遍历。由队列实现
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 首先记录每一层的数目，这个很重要
            int count = queue.size();
            double value = 0;
            // 弹出这一层的所有结点，并算出平均值，把下一层的结点也加入队列中
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                value += node.val;
            }
            res.add(value / count);
        }
        return res;
    }
}

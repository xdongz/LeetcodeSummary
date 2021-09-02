package Chapter06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No. 310 最小高度数
 *
 * 给你一棵包含n个节点的树，标记为0到n - 1 。给定数字n和一个有 n - 1 条无向边的 edges列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 这道题和210题有点像，它是先把叶子结点加入到队列中，然后从叶子结点往上找
 *
 */
public class FindMinHeightTrees {
    public static void main(String[] args) {
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        //int[][] edges = {{0,1}};
        System.out.println(findMinHeightTrees(6, edges));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 把叶子结点加入到队列中
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
               int node = queue.poll();
               res.add(node);
               List<Integer> neighbors = map.get(node);
               for (int neighbor : neighbors) {
                   // 每弹出一个叶子结点，那么与之相连的结点的度就减一
                   degree[neighbor]--;
                   // 表示这个点是叶子结点
                   if (degree[neighbor] == 1) {
                       queue.offer(neighbor);
                   }
               }
            }
        }
        return res;
    }
}

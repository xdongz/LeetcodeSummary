
package Chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * No.797 所有可能的路径
 *
 * 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 */
public class AllPathSourceTarget {

  public static void main(String[] args) {
    int[][] graph = {{4,3,1},{3,2,4},{},{4},{}};
    System.out.println(allPathsSourceTarget(graph));
  }

  public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    // 总共n个数，所求的是0到n-1的所有路径
    int n = graph.length;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(0);
    dfs(graph, path, res, 0, n);
    return res;
  }

  public static void dfs(int[][] graph, List<Integer> path, List<List<Integer>> res, int i, int n) {
    if (graph[i].length == 0) {
      return;
    }

    // 下一层
    int[] next = graph[i];
    for (int j = 0; j < next.length; j++) {
      // 先把结点加入path
      path.add(graph[i][j]);
      if (graph[i][j] == n-1) {
        // 如果到了n-1，就不再寻找下一层
        res.add(new ArrayList<>(path));
      } else {
        dfs(graph, path, res, graph[i][j], n);
      }
      // 回溯
      path.remove(path.size() - 1);
    }
  }

}

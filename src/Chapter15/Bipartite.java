
package Chapter15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * No.785 判断二分图
 *
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图
 *
 * 二分图算法也称为染色法，可以用广度优先搜索。
 * 如果一个节点染成了红色，那么与之相邻的节点应被染成绿色，直到所有的节点都遍历完或者遇到应染的颜色与已经染的颜色不同为止
 */
public class Bipartite {

  private final static int UNCOLORED = 0;
  private final static int GREEN = 1;
  private final static int RED = 2;

  public static void main(String[] args) {
    int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
    System.out.println(isBipartite(graph));
  }

  public static boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n];
    Arrays.fill(color, UNCOLORED);
    Queue<Integer> queue = new LinkedList<>();

    // 遍历0到n-1个节点
    for (int i = 0; i < n; i++) {
      // 如果该节点未染色，则可以默认给个颜色，如红色
      // 因为按照广度优先搜索，如果该节点未染色，要么是第一个节点，要么之前的所有节点都不相连，那么可以统一给个默认值
      if (color[i] == UNCOLORED) {
        // 如果已经染色的节点，便不用再加入队列中，判断其相邻的节点了，因为已经判断过了。
        queue.offer(i);
        color[i] = RED;
      }
      while (!queue.isEmpty()) {
        int node = queue.poll();
        // 该节点相邻的节点一定是与之相反的颜色
        int cNei = color[node] == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
          // 如果未染色，则染成相反的颜色， 并把这些节点放入队列中，再去判断与之相邻的节点
          if (color[neighbor]  == UNCOLORED) {
            color[neighbor] = cNei;
            queue.offer(neighbor);
            // 如果染色了，但是颜色又不一致就直接返回false
          } else if (color[neighbor] != cNei) {
            return false;
          }
        }
      }
    }
    return true;
  }

}


package Chapter02;

import java.util.Arrays;

/**
 * No.743 网络延迟时间
 *
 * 有 n 个网络节点，标记为1到 n。
 *
 * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
 *
 * Dijkstra算法
 */
public class NetworkDelayTime {

  public static void main(String[] args) {
    int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
    System.out.println(networkDelayTime(times, 4, 2));
  }

  public static int networkDelayTime(int[][] times, int n, int k) {
    // dist[]代表顶点到target的距离
    int[] dist = new int[n];
    int INF = Integer.MAX_VALUE / 2;
    Arrays.fill(dist, INF);
    dist[k-1] = 0;
    int[][] g = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(g[i], INF);
    }
    for (int[] time : times) {
      int x = time[0]-1, y = time[1]-1;
      g[x][y] = time[2];
    }

    boolean[] used = new boolean[n];

    // 遍历n次
    for (int i = 0; i < n; i++) {
      int x = -1;
      for (int y = 0; y < n; y++) {
        // 找出到顶点距离最小的点，记为x
        if (!used[y] && (x == -1 || dist[y] < dist[x])) {
          x = y;
        }
      }
      used[x] = true;
      // 更新以x为媒介，各个点到target的最小距离
      for (int y = 0; y < n; y++) {
        dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
      }
    }

    int ans = Arrays.stream(dist).max().getAsInt();
    return ans == INF ? -1 : ans;
  }

}

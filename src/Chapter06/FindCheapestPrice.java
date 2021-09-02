
package Chapter06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.787 K站中转内最便宜的航班
 * 这题没通过，很奇怪
 */
public class FindCheapestPrice {
  static int minPrice = Integer.MAX_VALUE;

  public static void main(String[] args) {
    int n = 3, src = 0, dst = 2, K = 0;
    int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
    System.out.println(findCheapestPrice(n, flights, src, dst, K));
  }

  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    // 1. 把from和to的关系存入map
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < flights.length; i++) {
      List<int[]> list = map.getOrDefault(flights[i][0], new ArrayList<>());
      int[] arr = {flights[i][1], flights[i][2]};
      list.add(arr);
      map.put(flights[i][0], list);
    }
    dfs(n, src, dst, K, -1, map, 0);
    return minPrice;
  }

  public static void dfs(int n, int src, int dst, int K, int level, Map<Integer, List<int[]>> map, int sum) {
    if (level == K) {
      return;
    }

    // 下一层
    List<int[]> nexts = map.get(src);
    if (nexts == null) {
      return;
    }
    for (int[] next : nexts) {
      sum+= next[1];
      if (next[0] == dst) {
        minPrice = Math.min(minPrice, sum);
      }
      dfs(n, next[0], dst, K, level+1, map, sum);
      sum = sum- next[1];
    }
  }

}

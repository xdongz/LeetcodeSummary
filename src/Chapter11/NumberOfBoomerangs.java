package Chapter11;

import java.util.HashMap;
import java.util.Map;

/**
 * No. 447 回旋镖的数量
 *
 * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量
 */
public class NumberOfBoomerangs {
  public static void main(String[] args) {
    int[][] points = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
    System.out.println(numberOfBoomerangs(points));
  }

  public static int numberOfBoomerangs(int[][] points) {
    int n = points.length;
    if (n < 3) {
      return 0;
    }
    // 用map来存储距离和对应的个数
    int count = 0;
    for (int[] p : points) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int[] q : points) {
        int dis = dist(p,q);
        if (map.containsKey(dis)) {
          count += map.get(dis) * 2;
        }
        map.put(dis, map.getOrDefault(dis, 0) + 1);
      }
    }

    return count;
  }
  public static int dist(int[] p1, int[] p2) {
    return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
  }
}

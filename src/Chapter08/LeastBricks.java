
package Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.554 砖墙
 *
 * 解题思路：把最少穿过的砖块数量转换成最多的空隙。然后遍历每一行，将每行的空隙存入map中。
 */
public class LeastBricks {

  public static void main(String[] args) {
    List<List<Integer>> wall = new ArrayList<>();
    wall.add(new ArrayList<>(Arrays.asList(1,2,2,1)));
    wall.add(new ArrayList<>(Arrays.asList(3,1,2)));
    wall.add(new ArrayList<>(Arrays.asList(1,3,2)));
    wall.add(new ArrayList<>(Arrays.asList(2,4)));
    wall.add(new ArrayList<>(Arrays.asList(3,1,2)));
    wall.add(new ArrayList<>(Arrays.asList(1,3,1,1)));
    System.out.println(leastBricks(wall));
  }

  public static int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> map = new HashMap<>();

    for (List<Integer> bricks : wall) {
      int sum = 0;
      for (int i = 0; i < bricks.size()-1; i++) {
        sum += bricks.get(i);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }

    int maxCnt = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      maxCnt = Math.max(maxCnt, entry.getValue());
    }
    return wall.size() - maxCnt;
  }

}


package Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.1743 从相邻元素还原数组
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 */
public class RestoreArray {

  public static void main(String[] args) {
    int[][] adjacentPairs = {{4,10},{-1,3},{4,-3},{-3,3}};
    System.out.println(Arrays.toString(restoreArray(adjacentPairs)));
  }

  public static int[] restoreArray(int[][] adjacentPairs) {
    int n = adjacentPairs.length;
    int[] ans = new int[n+1];
    // 1. 将每个数相邻的数存在map中
    Map<Integer, List<Integer>> map = new HashMap<>();
    int first = adjacentPairs[0][0];
    for (int i = 0; i < n; i++) {
      List<Integer> list1 = map.getOrDefault(adjacentPairs[i][0], new ArrayList<>());
      list1.add(adjacentPairs[i][1]);
      map.put(adjacentPairs[i][0], list1);

      List<Integer> list2 = map.getOrDefault(adjacentPairs[i][1], new ArrayList<>());
      list2.add(adjacentPairs[i][0]);
      map.put(adjacentPairs[i][1], list2);

    }
    // 2. 将其中一个相邻数只有1个的作为数组的开头
    for (Integer key : map.keySet()) {
      if (map.get(key).size() == 1) {
        first = key;
        break;
      }
    }

    // 3. 复原数组
    ans[0] = first;
    int last = first;
    for (int i = 1; i < n+1; i++) {
      List<Integer> list = map.get(first);
      if (list.size() == 1) {
        ans[i] = list.get(0);
        first = list.get(0);
      } else {
        for (int j = 0; j < 2; j++) {
          if (list.get(j) != last) {
            ans[i] = list.get(j);
            last = first;
            first = list.get(j);
            break;
          }
        }
      }
    }
    return ans;
  }

}

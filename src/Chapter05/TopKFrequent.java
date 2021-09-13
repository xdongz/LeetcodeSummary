
package Chapter05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * No.347 前K个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 */
public class TopKFrequent {

  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxtCount = 0;
    // 把每个元素以及对应的频次放入map中
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      maxtCount = Math.max(maxtCount, map.get(num));
    }

    // bucket中存放频次和对应的元素集
    List<List<Integer>> bucket = new ArrayList<>();
    for (int i = 0; i <= maxtCount; i++) {
      bucket.add(new ArrayList<>());
    }

    for (int key : map.keySet()) {
      int value = map.get(key);
      bucket.get(value).add(key);
    }

    int count = 0;
    int[] res = new int[k];
    // 从大到小取出k个元素
    for (int i = maxtCount; i > 0; i--) {
      List<Integer> temp;
      temp = bucket.get(i);
      if (count < k) {
        for (Integer integer : temp) {
          res[count++] = integer;
          if (count == k) {
            break;
          }
        }
      }
      if (count == k) {
        break;
      }

    }
    return res;
  }

}

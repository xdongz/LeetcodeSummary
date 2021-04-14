
package Chapter11;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * No.697 数组的度
 * 给定一个非空且只包含非负数的整数数组nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 这道题就是先找出出现最多次数的元素x，最短的子数组将是x从第一次出现到最后一次出现的数组
 * 所以本题的解法定义了三个map，分别存储x对应的次数，x第一次出现的索引和x最后一次出现的索引
 */
public class DegreeofArray {

  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> left = new HashMap<>(),
        right = new HashMap<>(), count = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
      if (!left.containsKey(nums[i])) {
        left.put(nums[i], i);
      }
      right.put(nums[i], i);
    }

    Set<Integer> key = count.keySet();
    int max = Collections.max(count.values());

    int minSize = nums.length;
    for (int k : key) {
      if (count.get(k) == max) {
        minSize = Math.min(right.get(k) - left.get(k) + 1, minSize);
      }
    }
    return minSize;
  }

}

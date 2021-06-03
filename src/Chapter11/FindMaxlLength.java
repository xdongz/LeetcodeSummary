package Chapter11;

import java.util.HashMap;
import java.util.Map;

/**
 * No.525 连续数组
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 没想到这题也能用前缀和，其实就是把0想象成-1，连续数组和为0的最大长度
 */
public class FindMaxlLength {

  public static void main(String[] args) {
    int[] nums = {0,1,0};
    System.out.println(findMaxLength(nums));
  }

  public static int findMaxLength(int[] nums) {
    int n = nums.length;
    int count = 0, max = 0;
    // key是count的值，value是对应的索引
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) {
        count++;
      } else {
        count--;
      }
      if (map.containsKey(count)) {
        int id = map.get(count);
        max = Math.max(max, i - id);
      } else {
        map.put(count, i);
      }
    }
    return max;
  }
}

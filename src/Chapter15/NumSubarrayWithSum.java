
package Chapter15;

import java.util.HashMap;
import java.util.Map;

/**
 * No.930 和相同的二元子数组
 *
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 */
public class NumSubarrayWithSum {

  public static void main(String[] args) {
    int[] nums = {1,0,1,0,1};
    int goal = 2;
    System.out.println(numSubarrayWithSum(nums, goal));
  }

  // 方法一：前缀和
  public static int numSubarrayWithSum(int[] nums, int goal) {
    int n = nums.length;
    int[] preSum = new int[n];
    preSum[0] = nums[0];
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    map.put(preSum[0], map.getOrDefault(preSum[0], 0)+1);
    int count  = preSum[0] == goal ? 1 : 0;
    for (int i = 1; i < n; i++) {
      preSum[i] = preSum[i-1] + nums[i];
      int val = preSum[i] - goal;
      count += map.getOrDefault(val, 0);
      map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
    }
    return count;

  }

}

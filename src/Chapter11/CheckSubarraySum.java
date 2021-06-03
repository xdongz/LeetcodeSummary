
package Chapter11;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 *
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 *
 * 想到了前缀和，却没想到同余，以至于超时了。
 * 如果(preSump[i]-preSum[j])%k==0, 那么preSum[i]%k == preSum[j]%k
 * 所以用一个map来存放余数和索引就可以了。
 * 需要注意的是要首先设置map.put(0, -1)，这样可以是的当preSum[i]%k == 0 && i != 0 的时候也能返回true
 */
public class CheckSubarraySum {

  public static void main(String[] args) {
    int[] nums = {23,2,6,4,7};
    System.out.println(checkSubarraySum(nums, 6));
  }
  public static boolean checkSubarraySum(int[] nums, int k) {
    int[] preSum = new int[nums.length];
    preSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      preSum[i] = preSum[i-1] + nums[i];
    }

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      int remain = preSum[i] % k;
      if (map.containsKey(remain)) {
        int value = map.get(remain);
        if (i - value > 1) {
          return true;
        }
      } else {
        map.put(remain, i);
      }
    }
    return false;
  }

}

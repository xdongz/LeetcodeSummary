
package Chapter03;

import java.util.TreeSet;

/**
 * No.220 存在重复元素|||
 *
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在两个下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * 一个之前没用过的数据结构：TreeSet
 *
 */
public class ContainsNearbyAlmostDuplicate {

  public static void main(String[] args) {
    int[] nums = {1,2,3,1};

    int k = 3, t = 0;
    System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
  }

  public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      // 返回大于或等于num[i] - t 的元素
      Long cell = set.ceiling((long)nums[i] - (long)t);
      if (cell != null && cell <= (long)nums[i] + (long)t) {
        return true;
      }
      set.add((long)nums[i]);
      if (i >= k) {
        //如果该treeset中有重复的元素，那么肯定返回true了，就不会走到这里
        set.remove((long) nums[i-k]);
      }

    }
    return false;
  }
}


package Chapter11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * No.217
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = {};
    System.out.println(containsDuplicate(nums));
  }

  /**
   * 这道题很简单，做法也很多，比如用map，set，或者排序之后看相邻的元素是否相等
   */
  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

  //这个方法比上一个耗时少
  public static boolean method2(int[] nums) {
    Arrays.sort(nums);

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return true;
      }
    }
    return false;
  }

}


package Chapter11;

import java.util.HashSet;
import java.util.Set;

/**
 * No.287 寻找重复的数
 *
 * 与findDisppearedNumber和containsDuplicate方法类似
 */
public class FindDuplicate {
  //利用set解决
  public int findDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return num;
      }
      set.add(num);
    }
    return -1;
  }

  //修改nums数组解决方法
  public int method2(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int id = Math.abs(nums[i]) - 1;
      if (nums[id] < 0) {
        return Math.abs(nums[i]);
      }
      nums[id] = -nums[id];
    }
    return -1;
  }

}

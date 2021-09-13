
package Chapter11;

import java.util.HashMap;
import java.util.Map;

/**
 * No.594 最长和谐子序列
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *。
 */
public class FindLHS {

  public static void main(String[] args) {
    int[] nums = {1,1,1,1};
    System.out.println(findLHS(nums));
  }

  public static int findLHS(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int max = 0;
    for (int num : nums) {
      int length = 0;
      //为了避免重复，只需要看比这个num大1 的数有多少个，或者比这个num小1 的数有多少个
      if (map.containsKey(num + 1)) {
        //注意：子序列中最大值和最小值的差值一定要正好是1
        length = map.get(num) + map.getOrDefault(num + 1, 0);
      }

      max = Math.max(max, length);
    }
    return max;
  }

}

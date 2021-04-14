
package Chapter11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.128 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度
 */
public class LongestConsecutive {

  public static void main(String[] args) {
    int[] nums = {0,3,7,2,5,8,4,6,0,1};
    System.out.println(method3(nums));
  }

  /**
   * 第一种方法：先排序，用一个map保存当前值和对应的最长序列的长度
   * 遍历数组，如果当前值-1不在map中，设置对应值为1，如果在数组中，设置对应值为前者对应的value+1
   *
   */
  public static int longestConsecutive(int[] nums) {
    Arrays.sort(nums);

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i] - 1, 0) +1);
      max = Math.max(max, map.get(nums[i]));
    }
    return max;
  }

  /**
   * 第二种方法：没有用排序，先将所有的值存入set，然后遍历数组
   * 将当前值所有前面的数和后面的数都删除，每删除一个数，对应的子序列长度就加1
   *
   */
  public static int method2(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    int max = 0;

    for (int n : nums) {
      int next = 1, prev = 1;
      set.remove(n);
      while (set.contains(n + next)) {
        set.remove(n + next);
        next ++;
      }

      while (set.contains(n - prev)) {
        set.remove(n - prev);
        prev ++;
      }

      max = Math.max(next + prev - 1, max);
    }
    return max;
  }

  /**
   * 第三种方法：第二种方法中不断地删除元素，也会造成运行时间增加
   * 所以我们不删除元素，只是用一个变量去记录最长子序列的长度
   *
   */
  public static int method3(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }

    int max = 0;
    for (int n : nums) {
      //只关心子序列中最小的那个元素
      if (!set.contains(n - 1)) {
        int next = 1;
        int currNum = 1;
        //得出这个元素后面的还有有多少个元素，即为这个元素能组成的最长子序列
        while (set.contains(n + next)) {
          next ++;
          currNum ++;
        }
        max = Math.max(max, currNum);
      }
    }
    return max;
  }

}

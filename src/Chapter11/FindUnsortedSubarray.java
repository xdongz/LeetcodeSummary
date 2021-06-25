package Chapter11;

import java.util.Arrays;

/**
 * No.581 最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 这题很简单，首先想到的方法是排序，然后比较不相同的左右索引
 *
 * 还有一种不使用额外空间的做法，这里不写了
 */
public class FindUnsortedSubarray {

  public static void main(String[] args) {
    int[] nums = {1};
    System.out.println(findUnsortedSubarray(nums));
  }

  public static int findUnsortedSubarray(int[] nums) {
    int[] raw = nums.clone();
    Arrays.sort(nums);

    int left = nums.length, right = 0;
    for (int i = 0; i < nums.length; i++) {
      if (raw[i] != nums[i]) {
        left = Math.min(left, i);
        right = Math.max(right, i);
      }
    }

    return right > left ? right-left+1 : 0;
  }

}

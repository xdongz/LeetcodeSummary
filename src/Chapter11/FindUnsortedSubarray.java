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
    int[] nums = {2,6,4,8,10,9,15};
    System.out.println(method2(nums));
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

  public static int method2(int[] nums) {
    int n = nums.length;
    int maxn = Integer.MIN_VALUE, right = -1;
    int minn = Integer.MAX_VALUE, left = -1;

    for (int i = 0; i < n; i++) {
      // 1.从前往后找出最大值应该在的位置right
      // 如果当前值比maxn大，那么更新maxn，
      // 否则更新right，因为需要把前面那个更大的值至少移到当前位置上来
      if (nums[i] >= maxn) {
        maxn = nums[i];
      } else {
        right = i;
      }

      // 2.从后往前找出最小值应该在的位置left
      // 如果当前值比minn小，那么更新minn，
      // 否则更新left，因为需要把后面那个更小的值至少移到当前位置上来
      if (nums[n-i-1] <= minn) {
        minn = nums[n-i-1];
      } else {
        left = n-i-1;
      }
    }

    // 3.right-left+1即为所求
    return right == -1 ? 0 : right - left + 1;
  }

}

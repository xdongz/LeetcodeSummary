
package Chapter07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.300 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class LongestIncreasingSubseq {

  public static void main(String[] args) {
    int[] nums = {10,9,2,5,3,7,101,18};
    System.out.println(LengthOfLIS(nums));
  }

  // 贪心
  /**
   * 如果我们要使上升子序列尽可能长，那么序列应尽可能上升地慢，所以每次在上升子序列后加的那个数应该尽可能小
   *
   * 以输入序列 [0, 8, 4, 12, 2][0,8,4,12,2] 为例：
   * 第一步插入 0，d = [0]d=[0]；
   * 第二步插入 8，d = [0, 8]d=[0,8]；
   * 第三步插入 4，d = [0, 4]d=[0,4]；
   * 第四步插入 12，d = [0, 4, 12]d=[0,4,12]；
   * 第五步插入 2，d = [0, 2, 12]d=[0,2,12]。
   */
  public static int LengthOfLIS(int[] nums) {
    List<Integer> list = new ArrayList<>();
    list.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > list.get(list.size() - 1)) {
        list.add(nums[i]);
      } else {
        // 找到list中比nums[i]小的最大的数，并更新
        int l = 0, r = list.size() - 1, pos = 0;
        while (l <= r) {
          int mid = (l + r) /2;
          if (list.get(mid) < nums[i]) {
            l = mid + 1;
          } else {
            pos = mid;
            r = mid - 1;
          }
        }
        list.set(pos, nums[i]);
      }
    }
    return list.size();

  }

  // 动态规划：dp[i]表示以i结尾的最长子序列的长度
  public static int method2(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    int max = 1;
    Arrays.fill(dp, 1);
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(dp[i], max);
    }
    return max;
  }

}

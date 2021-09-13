
package Chapter07;

import java.util.Arrays;

/**
 * No.416 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 我觉得此题最关键的问题是，想到用动态规划来解
 * 其实这个问题和0-1背包问题很像，考虑遍历到第i个物品时，总体积是sum/2的值是true还是false
 *
 */
public class Partition {

  public static void main(String[] args) {
    int[] nums = {2};
    System.out.println(canPartition(nums));
  }

  public static boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    if (sum % 2 == 1) {
      return false;
    }

    sum = sum / 2;
    int n = nums.length;
    // 用二维矩阵来解决此题
//    boolean[][] dp = new boolean[n+1][sum+1];
//    for (boolean[] d : dp) {
//      Arrays.fill(d, false);
//    }
//    dp[0][0] = true;
//    for (int i = 1; i <= n ; i++) {
//      for (int j = 1; j <= sum; j++) {
//        if (j >= nums[i-1]) {
//          dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
//        } else {
//          dp[i][j] = dp[i-1][j];
//        }
//      }
//    }


    // 压缩空间后
    boolean[] dp = new boolean[sum+1];
    Arrays.fill(dp, false);
    dp[0] = true;
    for (int i = 1; i <= n ; i++) {
      for (int j = sum; j >= nums[i-1]; j--) {
        if (j >= nums[i-1]) {
          dp[j] = dp[j] || dp[j-nums[i-1]];
        } else {
          dp[j] = dp[j];
        }
      }
    }

    return dp[sum];
  }

}


package Chapter07;

import java.util.Arrays;

/**
 * No. 740 删除并获得点数
 *
 * 给你一个整数数组nums，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除每个等于nums[i] - 1或nums[i] + 1的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 解题思路：这道题和打家劫舍一样我也是万万没想到。
 * 最关键的思路是将nums数组转换成sum数组，sum数组的索引对应这nums数组的值，
 * 这样就可以通过判断sum相邻索引从而看是否将某个位置的元素删除或者不删除
 *
 */
public class DeleteAndEarn {

  public static void main(String[] args) {
    int[] nums = {2,2,3,3,3,4};
    System.out.println(deleteAndEarn(nums));
  }

  public static int deleteAndEarn(int[] nums) {
    int maxVal = 0;
    for (int num : nums) {
      maxVal = Math.max(maxVal, num);
    }

    // 最关键的思路
    int[] sum = new int[maxVal + 1];
    Arrays.fill(sum, 0);
    for (int num : nums) {
      sum[num] += num;
    }

    int[] dp = new int[maxVal + 1];
    dp[0] = sum[0];
    dp[1] = Math.max(sum[0], sum[1]);
    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2] + sum[i]);
    }
    return dp[maxVal];
  }

}

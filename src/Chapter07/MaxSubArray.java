package Chapter07;

import java.util.Arrays;

/**
 * 53.最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 这道题和413题ArithmeticsSlices有一点像，像这种连续子数组的题目，dp[i]一般都为包含索引i的连续子数组
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp[i]表示包含索引i的连续子数组的最大和。
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i-1] >= 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    // 优化成常数
    public static int method2(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int dp = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp >= 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }
}

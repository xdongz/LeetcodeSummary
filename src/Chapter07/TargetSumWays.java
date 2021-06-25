package Chapter07;

import java.util.Arrays;

/**
 *  No.494 目标和
 *
 *  给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号+和-。对于数组中的任意一个整数，你都可以从+或-中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 这道题可以想成0-1背包问题
 */
public class TargetSumWays {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int S = 3;
        System.out.println(findTargetSumWays(nums, S));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        //dp[i][j]前i件物品，总数为j最多多少种
        // dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]] 可以写成：
        // dp[i][j + nums[i]] += dp[i - 1][j]
        // dp[i][j - nums[i]] += dp[i - 1][j]
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                // 这个判断条件用来保证数组不越界，但是还没看懂
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }


    public static int find2(int[] nums, int S) {
        // 1. 先求出nums的总和sum
        int sum = Arrays.stream(nums).sum();
        // 2. 假设前面添加负号的元素之和为neg，那么添加正号的元素之和为sum-neg，则S=sum-neg-neg
        if (sum < S || (sum - S) % 2 != 0) {
            return 0;
        }
        int neg = (sum - S) / 2;
        // 3. 该问题转换为从nums数组中取几个数，使得他们的总和为neg
        int n = nums.length;
        int[][] dp = new int[n+1][neg+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][neg];
    }
}

package Chapter07;

/**
 * No.213 打家劫舍II
 * 与198题不同的是，这次房屋首位相连，是一个环形
 */
public class HourseRobII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        int max = 0;
        // 如果偷1号房子，那么就不能偷最后一号房子
        dp[0] = nums[0];
        dp[1] = dp[0];
        for (int i = 2; i < n-1; i++) {
          dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])  ;
        }
        max = dp[n-2];
        // 如果不偷1号房子，那么最后一号可偷可不偷
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])  ;
        }
        max = Math.max(max, dp[n-1]);
        return max;
    }
}

package Chapter07;

/**
 * No. 413 等差数列划分
 *
 * 求一个数组中的等差数列子数组有多少个
 *
 * 这道题的关键点是想出dp[i]代表什么，以及动态方程
 */
public class ArithmeticsSlices {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(nums));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的等差数列的个数
        int[] dp = new int[n];
        dp[0] = dp[1] = 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}

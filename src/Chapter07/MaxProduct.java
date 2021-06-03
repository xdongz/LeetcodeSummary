package Chapter07;

/**
 * No.152 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 这道题虽然想到了动态规划，却没想好负数的情况。
 *
 * 之前在处理连续子数组的最大和时，dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
 * 其中dp[i]表示以索引i结尾的最大连续子数组和
 * 但这道题却不能这么简单用，因为它存在负负得正。
 * 所以可以用两个数组，分别表示以i结尾的最大连续子数组乘积和最小连续子数组乘积
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {7,-2,-4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums, 0, maxF, 0, n);
        System.arraycopy(nums, 0, minF, 0, n);
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            // 动态规划方程
           maxF[i] = Math.max(nums[i], Math.max(maxF[i-1] * nums[i], minF[i-1] * nums[i]));
           minF[i] = Math.min(nums[i], Math.min(minF[i-1] * nums[i], maxF[i-1] * nums[i]));
           max = Math.max(maxF[i], max);
        }
        return max;
    }
}

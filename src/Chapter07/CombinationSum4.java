package Chapter07;

/**
 * No.377 组合总合IV
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *
 * 这道题用回溯超时了，只能用动态规划。
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,8,9,10};
        System.out.println(combinationSum4(nums, 10));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 1; i <= target ; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}

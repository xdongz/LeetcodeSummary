package Chapter07;

import java.util.Arrays;

/**
 * No.343 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE / 2);
        dp[1] = 1;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                // 每一步可以选择拆分，也可以选择不拆分
                dp[i] = Math.max(j * (i-j), Math.max(dp[i], j * dp[i-j]));
            }
        }
        return dp[n];
    }
}

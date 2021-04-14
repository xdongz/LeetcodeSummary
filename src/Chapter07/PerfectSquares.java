
package Chapter07;

import java.util.Arrays;

/**
 * No.279 完全平方数
 *
 * 给定一个正整数，求其最少可以由几个完全平方数相加构成。
 */
public class PerfectSquares {

  public static void main(String[] args) {
    System.out.println(numSquares(13));
  }
  public static int numSquares(int n) {
    int[] dp = new int[n+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < n+1; i++) {
      for (int j = 1; j*j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
      }
    }
    return dp[n];
  }

}

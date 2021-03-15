/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter07;

import java.util.Arrays;

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

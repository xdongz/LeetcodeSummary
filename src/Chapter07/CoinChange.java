/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter07;

import java.util.Arrays;

/**
 * No.322 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的
 *
 * 完全背包问题。
 */
public class CoinChange {

  public static void main(String[] args) {
    int[] coins = {1};
    System.out.println(coinChange(coins, 1));
  }

  public static int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, 10001);
    dp[0] = 0;

    for (int i = 1; i < n + 1; i++) {
      int w = coins[i-1];
      for (int j = w; j <= amount; j++) {
        dp[j] = Math.min(dp[j], dp[j - w] + 1);
      }
    }
    return dp[amount] == 10001 ? -1 : dp[amount];
  }

}

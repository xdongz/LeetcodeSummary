/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter07;

/**
 * No.1269 停在原地的方案数
 *
 * 有一个长度为arrLen的数组，开始有一个指针在索引0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数steps 和arrLen ，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0 处的方案数。
 *
 * 对于计算方案数的题目，常用的方法就是动态规划
 */
public class NumWays {

  public static void main(String[] args) {
    System.out.println(numWays(27, 7));
  }

  public static int numWays(int steps, int arrLen) {
    final int MODULO = 1000000007;
    int maxColumn = Math.min(arrLen-1, steps);
    int[][] dp = new int[steps+1][maxColumn+1];
    for (int j = 0; j <= maxColumn; j++) {
      dp[0][j] = 0;
    }
    dp[0][0] = 1;
    for (int i = 1; i < steps+1; i++) {
      for (int j = 0; j <= maxColumn; j++) {
        if (j == 0) {
          dp[i][j] = (dp[i-1][j] + dp[i-1][j+1]) % MODULO;
        } else if (j == maxColumn){
          dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % MODULO;
        } else {
          // 必须要分开求，因为两数相加就有可能溢出。
          dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % MODULO;
          dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MODULO;
        }

      }
    }
    return dp[steps][0];
  }
}

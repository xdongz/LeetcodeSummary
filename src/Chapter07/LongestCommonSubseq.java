/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter07;

import java.util.Arrays;

/**
 * No.1143 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 解题思路：此题关键要想出用动态规划来做。dp[i][j]表示第一个string到第i个位置为止，第二个string到第j个位置为止最长的公共子序列长度
 */
public class LongestCommonSubseq {

  public static void main(String[] args) {
    String text1 = "abc", text2 = "def";
    System.out.println(longestCommonSubsequence(text1, text2));
  }

  public static int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m+1][n+1];

    for (int[] d : dp) {
      Arrays.fill(d, 0);
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i-1) == text2.charAt(j-1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[m][n];
  }
}

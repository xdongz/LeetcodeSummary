/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter07;

import java.util.Arrays;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *
 *
 * 动态规划：其中dp[i][j] 表示以i 截止的字符串是否可以被以j 截止的正则表达式匹配
 */
public class RegressionMatch {

  public static void main(String[] args) {
    String s = "mississippi", p = "mis*is*p*.";
    System.out.println(isMatch(s, p));
  }

  public static boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m+1][n+1];
    for (boolean[] d : dp) {
      Arrays.fill(d, false);
    }

    dp[0][0] = true;
    for (int i = 1; i < n + 1; i++) {
      if (p.charAt(i-1) == '*') {
        dp[0][i] = dp[0][i-2];
      }
    }

    for (int i = 1; i < m+1; i++) {
      char ch1 = s.charAt(i-1);
      for (int j = 1; j < n+1; j++) {
        char ch2 = p.charAt(j-1);
        // 当p的当前字符是.时，可以匹配任何字符，所以只需看dp[i-1][j-1]
        if (ch2 == '.') {
          dp[i][j] = dp[i-1][j-1];
        } else if (ch2 != '*'){
          // ch2 为字母的情况, 如果当前字符与s的当前字符不同，则为false，否则要看dp[i-1][j-1]
          dp[i][j] = dp[i-1][j-1] && ch1 == ch2;
          // 当ch2为‘*’时
        } else if (j >= 2) {
          // 需要比较ch2的前一个字符
          if (p.charAt(j-2) != ch1 && p.charAt(j-2) != '.') {
            // 此时‘*’相当于匹配0次前面那个元素
            dp[i][j] = dp[i][j-2];
          } else {
            // 当ch2的前一个字符等于ch1，或者ch2的前一个字符是‘.'
            // ch2的前一个字符可以出现0次，1次，或者多次
            dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i][j-2];

          }
        }
      }
    }
    return dp[m][n];
  }

}

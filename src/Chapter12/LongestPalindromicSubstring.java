/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter12;

/**
 * No.5 最长回文子串
 *
 * 给你一个字符串s，找到s中最长的回文子串
 *
 * 这道题和CountSubString这道题差不多
 * 主要有两种方法：动态规划和中心扩展法，还有一种Manacher 算法这里暂不提及
 *
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String s = "aacabdkacaa";
    System.out.println(method2(s));
  }

  /**
   * 方法一： 动态规划
   * dp[i][j]表示索引是[i, j]范围时，是否是回文串
   * 如果s[i] == s[j]，dp[i][j] = dp[i+1][j-1]，否则为false
   * 然后根据最长的j-i+1得到s的最长子串
   */
  public static String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int max = 0;
    String ans = "";

    for (int i = n-1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (i == j) {
          dp[i][j] = true;
        } else {
          boolean flag = s.charAt(i) == s.charAt(j);
          if (j == i + 1) {
            dp[i][j] = flag;
          } else if (j - i >= 2) {
            dp[i][j] = flag && dp[i + 1][j - 1];
          }
        }

        if (dp[i][j] && (j - i + 1) > max) {
          max = j - i + 1;
          ans = s.substring(i, j+1);
        }
      }
    }
    return ans;
  }

  /**
   * 方法二： 中心扩展法
   * 中心扩展法的算法就不赘述了
   * 这里比较关键的是根据中心点以及字符串长度算出起始和结束的位置，从而得到s的子串
   */
  public static String method2(String s) {
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = extendString(s, i, i);
      int len2 = extendString(s, i, i+1);
      int len = Math.max(len1, len2);
      if (len > end - start + 1) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  public static int extendString(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left --;
      right ++;
    }
    return right - left - 1;
  }
}



package Chapter12;

/**
 * No. 516 最长回文子序列
 *
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LongestPalindromeSubseq {

  public static void main(String[] args) {
    String s = "aabaaba";
    System.out.println(longestPalindromeSubseq(s));
  }
  public static int longestPalindromeSubseq(String s) {
    // 动态规划
    int n = s.length();
    // dp[i][j]表示范围[i, j]中最长的回文子序列
    int[][] dp = new int[n][n];
    // 若s[i] == s[j] 那么dp[i][j] = dp[i+1][j-1]+2
    // 注意i要从后往前遍历，j要从前往后遍历。因为i要知道后一时刻的值，j要知道前一时刻的值。
    for (int i = n-1; i >= 0 ; i--) {
      for (int j = i; j < n; j++) {
        if (i == j) {
          dp[i][j] = 1;
        } else {
          boolean flag = s.charAt(i) == s.charAt(j);
          if (j == i+1) {
            dp[i][j] = flag ? 2 : 1;
          } else {
            if (flag) {
              dp[i][j] = dp[i+1][j-1] + 2;
            } else {
              // 如果s[i] != s[j]，那么s[i]和s[j]不可能同时作为回文串的开头和结尾。
              dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
          }
        }
      }
    }
    return dp[0][n-1];
  }

}

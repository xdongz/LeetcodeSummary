
package Chapter07;

import java.util.Arrays;

/**
 * No.72 编辑距离
 *
 * 给定两个字符串，已知你可以删除、替换和插入任意字符串的任意字符，求最少编辑几步可以将两个字符串变成相同。
 *
 * 动态规划：dp[i][j]表示第一个string到第i个位置为止，第二个string到第j个位置为止最少需要几步编辑
 *
 */
public class EditDist {

  public static void main(String[] args) {
    String word1 = "horse";
    String word2 = "ros";
    System.out.println(minDistance(word1, word2));
  }

  public static int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m+1][n+1];
    for (int[] d : dp) {
      Arrays.fill(d, Integer.MAX_VALUE);
    }
    for (int i = 0; i < n+1; i++) {
      dp[0][i] = i;
    }

    for (int i = 0; i < m+1; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i < m+1; i++) {
      char ch1 = word1.charAt(i-1);
      for (int j = 1; j < n+1; j++) {
        char ch2 = word2.charAt(j-1);
        if (ch1 == ch2) {
          // 当两个字符相等时，可以选择把两个字符都加进来，也可以选择删除ch1，或者删除ch2
          dp[i][j] = Math.min(dp[i][j-1] + 1, Math.min(dp[i-1][j-1], dp[i-1][j] + 1));
        } else {
          // 当两个字符不等时，可以选择修改其中的一个字符，可以选择删除ch1，或者删除ch2
          dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
        }
      }
    }
    return dp[m][n];
  }

}

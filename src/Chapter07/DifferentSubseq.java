
package Chapter07;

/**
 * No.115 不同的子序列
 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 *
 * 动态规划：dp[i][j]表示s[:i+1] 中有多少个t[:j+1]个子串
 */
public class DifferentSubseq {

  public static void main(String[] args) {
    String s = "babgbag", t = "bag";
    System.out.println(numDistinct(s, t));
  }

  public static int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    if (m < n) {
      return 0;
    }
    int[][] dp = new int[m + 1][n + 1];
    // 初始化很关键
    for (int i = 0; i <= m; i++){
      dp[i][0] = 1;
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j <= i && j < n + 1; j++) {
        if (s.charAt(i-1) == t.charAt(j-1)) {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        } else{
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[m][n];

  }

}


package Chapter07;

/**
 * No.221 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 */
public class MaximalSquare {

  public static void main(String[] args) {
    char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','0','1','1','1'}};
    System.out.println(maximalSquare(matrix));
  }

  // 动态规划
  // dp[i][j] 代表以（i，j）为右下角的最大正方形边长
  // 我们假设dp[i][j] = k，其充分条件为dp[i-1][j-1]、dp[i][j-1] 和dp[i-1][j] 的值必须都不小于k-1，否则(i, j) 位置不可以构成一个边长为k 的正方形。

  public static int maximalSquare(char[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '0') {
          dp[i][j] = 0;
        } else if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j] - '0';
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
        max = Math.max(dp[i][j], max);
      }
    }
    return max * max;
  }

}


package Chapter07;

import java.util.Arrays;

/**
 * No.64 最小路径总和
 *
 * 给定一个m * n 大小的非负整数矩阵，求从左上角开始到右下角结束的、经过的数字的和最
 * 小的路径。每次只能向右或者向下移动
 */
public class MinPathSum {

  public static void main(String[] args) {
    int[][] grid = {{1,2,3},{4,5,6}};
    System.out.println(method2(grid));
  }
  public static int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else if (i == 0) {
          dp[i][j] = dp[i][j-1] + grid[i][j];
        } else if (j == 0) {
          dp[i][j] = dp[i-1][j] + grid[i][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
      }
    }
    return dp[m-1][n-1];
  }

  // 空间压缩，从上面的方法来看，dp数组的值只与上一行和值和左边的值相关
  // 所以每次只存储上一行的dp值
  public static int method2(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] dp = new int[n];
    Arrays.fill(dp, 0);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[j] = grid[i][j];
        } else if (i == 0) {
          dp[j] = dp[j-1] + grid[i][j];
        } else if (j == 0) {
          dp[j] = dp[j] + grid[i][j];
        } else {
          dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
        }
      }
    }
    return dp[n-1];
  }

}


package Chapter07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * No. 542 01矩阵
 *
 * 给定一个由0 和1 组成的二维矩阵，求每个位置到最近的0 的距离。
 *
 */
public class OneZeroMatrix {

  public static void main(String[] args) {

    int[][] matrix = {{0,0,0}, {0,1,0}, {1,1,1}};
    int[][] ans = method2(matrix);
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(ans[i]));
    }
  }

  //  方法一： 广度优先搜索
  public static int[][] updateMatrix(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[] helper = {1,0,-1,0,1};
    int[][] ans = new int[m][n];
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(visited[i], false);
    }

    // 把所有值为0的加入到queue中
    // 以值为0的元素为中心广度遍历
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          queue.offer(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] node = queue.poll();
      int p = node[0], q = node[1];

      for (int i = 0; i < 4; i++) {
        int x = p + helper[i];
        int y = q + helper[i + 1];
        if (x >=0 && x < m && y >=0 && y < n && !visited[x][y]) {
          ans[x][y] = ans[p][q] + 1;
          visited[x][y] = true;
          queue.offer(new int[]{x, y});
        }
      }
    }
    return ans;

  }

  // 方法二：动态规划
  public static int[][] method2(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          // 注意这里要除以2，否则超出int最大值了
          dp[i][j] = Integer.MAX_VALUE/2;
        }
      }
    }

    // 先求出左移和上移的最小值
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i > 0) {
          dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
        }
        if (j > 0) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+ 1);
        }
      }
    }

    // 再求出右移和下移的最小值
    for (int i = m-1; i >= 0; i--) {
      for (int j = n-1; j >=0; j--) {
        if (i < m-1) {
          dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
        }
        if (j < n- 1) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
        }
      }
    }

    return dp;

  }


}

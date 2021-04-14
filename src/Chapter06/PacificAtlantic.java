
package Chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.417 太平洋大西洋水流问题
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 解题思路：分别从四条边看能倒灌到的区域，然后求太平洋和大西洋倒灌覆盖区域的重叠部分
 * 如果一个一个遍历矩阵中的元素，然后看能否流到四条边，需要考虑的情况太多了
 */
public class PacificAtlantic {

  public static void main(String[] args) {
    int[][] matrix = {
        {1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
    List<List<Integer>> ans = pacificAtlantic(matrix);
    for (List<Integer> a : ans) {
      System.out.println(a);
    }
  }

  public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> ans = new ArrayList<>();
    if (matrix.length == 0) {
      return ans;
    }

    int m = matrix.length, n = matrix[0].length;
    // P矩阵代表太平洋能倒灌到的区域，Q矩阵代表大西洋能倒灌到的区域
    boolean[][] P = new boolean[m][n];
    boolean[][] Q = new boolean[m][n];

    for (boolean[] p : P) {
      Arrays.fill(p, false);
    }
    for (boolean[] q : Q) {
      Arrays.fill(q, false);
    }
    int[] direct = {1,0,-1,0,1};

    for (int i = 0; i < m; i++) {
      if (!P[i][0]) {
        P[i][0] = true;
        dfs(matrix, i, 0, P, direct);
      }

      if (!Q[i][n-1]) {
        Q[i][n-1] = true;
        dfs(matrix, i, n-1, Q, direct);
      }
    }

    for (int i = 0; i < n; i++) {
      if (!P[0][i]) {
        P[0][i] = true;
        dfs(matrix, 0, i, P, direct);
      }

      if (!Q[m-1][i]) {
        Q[m-1][i] = true;
        dfs(matrix, m-1, i, Q, direct);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (P[i][j] && Q[i][j]) {
          List<Integer> temp = new ArrayList<>();
          temp.add(i);
          temp.add(j);
          ans.add(temp);
        }
      }
    }
    return ans;
  }

  public static void dfs(int[][] matrix, int i, int j, boolean[][] P, int[] direct) {
    for (int k = 0; k < 4; k++) {
      int x = i + direct[k], y = j + direct[k+1];
      if (x >=0 && x < matrix.length && y >= 0 && y < matrix[0].length && !P[x][y]) {
        if (matrix[x][y] >= matrix[i][j]) {
          P[x][y] = true;
          dfs(matrix, x, y, P, direct);
        }
      }
    }

  }
}

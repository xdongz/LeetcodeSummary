package Chapter06;

/**
 * No. 200 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 常规DFS, 也可以用BFS
 * 还可以用并查集
 */
public class NumIslands {

  public static void main(String[] args) {
    char [][] grid = {
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}

    };
    System.out.println(numIslands(grid));
  }

  public static int numIslands(char[][] grid) {
    int[] direct = {1, 0 , -1, 0, 1};
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] used = new boolean[m][n];
    int nums = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!used[i][j] && grid[i][j] == '1') {
          used[i][j] = true;
          nums++;
          dfs(grid, i, j, m, n, direct, used);
        }
      }
    }
    return nums;
  }

  public static void dfs(char[][] grid, int i, int j, int m, int n, int[] direct, boolean[][] used) {

    for (int k = 0; k < 4; k++) {
      int x = direct[k] + i;
      int y = direct[k+1] + j;
      if (x >=0 && x < m && y >=0 && y < n && !used[x][y] && grid[x][y] == '1') {
        used[x][y] = true;
        dfs(grid, x, y, m, n, direct, used);
      }
    }
  }

}

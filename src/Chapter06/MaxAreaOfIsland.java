/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter06;

import java.util.Arrays;

/**
 * No.695 岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组grid 。
 *
 * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 * 常规深度遍历的操作
 */
public class MaxAreaOfIsland {

  public static void main(String[] args) {
    int[][] grid = {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//    int[][] grid = {{0,1,0,0,0}};

    System.out.println(maxAreaOfIsland(grid));
  }

  public static int maxAreaOfIsland(int[][] grid) {
    int[] direct = {-1, 0 , 1, 0, -1};
    int m = grid.length, n = grid[0].length;
    int area = 0;
    // 避免重复计算
    boolean[][] visited = new boolean[m][n];
    for (boolean[] v : visited) {
      Arrays.fill(v, false);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        area = Math.max(dfs(grid, visited, m, n, i, j, direct, 0), area);
      }
    }
    return area;

  }

  public static int dfs(int[][] grid, boolean[][] visited, int m, int n, int i, int j, int[] direct, int area) {

    // 如果是1，而且还没有遍历到
    if (grid[i][j] == 1 && !visited[i][j]) {
      area++;
      visited[i][j] = true;
      for (int k = 0; k < 4; k++) {
        int x = i + direct[k], y = j + direct[k+1];
        if (x >=0 && x < m && y >= 0 && y < n && !visited[x][y]) {
          area = dfs(grid, visited, m, n, x, y, direct, area);
        }
      }
    }

    return area;
  }

}

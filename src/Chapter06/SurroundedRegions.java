/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter06;

/**
 * No.130 被围绕的区域
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 解题思路：这道题比较巧妙的是：与边界相连的O肯定不会被包围，而剩下的O肯定会被包围
 */
public class SurroundedRegions {
  public void solve(char[][] board) {
    if (board.length == 0) {
      return;
    }
    int m = board.length, n = board[0].length;

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        //判断是否是在边界上的0, 与边界上的O相连的O肯定不能被环绕
        if (i == 0 || i == m-1 || j==0 || j==n-1) {
          if(board[i][j] == 'O' ) {
            board[i][j] = 'A';
            dfs(board, m, n, i, j);
          }
        }
      }
    }

    // 没有与边界相连的O肯定能被环绕，所以直接改成X
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j] == 'A') {
          board[i][j] = 'O';
        }
      }
    }

  }

  public void dfs(char[][] board, int m, int n, int i, int j) {
    int[] direction = {-1, 0, 1, 0, -1};

    for (int k=0; k<4; k++) {
      int x = i+direction[k];
      int y = j+direction[k+1];
      if (x>=0 && x<m && y>=0 && y<n ) {
        if (board[x][y] == 'O') {
          board[x][y] = 'A';
          dfs(board, m, n, x, y);
        }
      }
    }
  }
}

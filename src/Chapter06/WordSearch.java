/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter06;

/**
 * No.79 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 深度遍历+回溯
 */
public class WordSearch {

  public static void main(String[] args) {
//    char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//    String word = "ABCB";
    char[][] board = {{'a'}};
    String word = "a";
    System.out.println(exist(board, word));
  }

  public static boolean exist(char[][] board, String word) {

    int[] direct = {1,0,-1,0,1};
    int m = board.length, n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        boolean result = backtracking(board, word, i, j, 0, direct, visited);
        // 只要有一次结果是true，就可返回，否则继续寻找
        if (result) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean backtracking(char[][] board, String word, int i, int j, int index, int[] direct, boolean[][] visited) {
    // 注意边界条件
    if (index == word.length() - 1) {
      return board[i][j] == word.charAt(index);
    }
    if (board[i][j] == word.charAt(index)) {
      // 修改本层状态
      visited[i][j] = true;
      // 下一层要做的事
      for (int k = 0; k < 4; k++) {
        int x = direct[k] + i, y = direct[k+1] + j;
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
          boolean result = backtracking(board, word, x, y, index+1, direct, visited);
          if (result) {
            return true;
          }
        }

      }
      // 恢复本层状态
      visited[i][j] = false;
    }
    return false;
  }

}

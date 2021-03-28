/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No. 943 最短的桥
 *
 * 在给定的二维二进制数组A中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * 现在，我们可以将0变为1，以使两座岛连接起来，变成一座岛。
 * 返回必须翻转的0 的最小数目。（可以保证答案至少是 1 。）
 *
 * 这道题比较巧妙的是，先找出一个岛，然后把岛屿周围的0加入到队列中，对0进行广度遍历，而不是直接对岛屿进行广度遍历
 *
 * 为了防止重复遍历，把找到的那个岛改为2
 */
public class ShortestBridge {

  public static void main(String[] args) {
    int[][] A = {{0,0,1,0,1},{0,1,1,0,1},{0,1,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
    System.out.println(shortestBridge(A));
  }

  public static int shortestBridge(int[][] A) {
    int m = A.length, n = A[0].length;
    int[] direct = {-1, 0, 1, 0, -1};

    Queue<int[]> queue = new LinkedList<>();
    List<int[]> pair = new ArrayList<>();
    boolean[][] visited = new boolean[m][n];

    boolean flag = false;
    for (int i = 0; i < m; i++) {
      if (flag) {
        break;
      }
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1) {
          A[i][j] = 2;
          dfs(A, queue, i, j, m, n, direct, visited);
          flag = true;
          // 找完一个岛屿后要立即break
          break;
        }
      }
    }


    int level = 0;
    // 广度遍历queue中的0
    while (!queue.isEmpty()) {
      level++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] temp = queue.poll();
        int r = temp[0], c = temp[1];
        for (int j = 0; j < 4; j++) {
          int x = r + direct[j], y = c + direct[j+1];
          if (x >= 0 && x < m && y >=0 && y < n) {
            if (A[x][y] == 1) {
              return level;
            } else if (A[x][y] == 0) {
              queue.offer(new int[] {x, y});
              // 防止重复遍历
              A[x][y] = 2;
            }
          }
        }
      }
    }
    return level;
  }

  // 找到其中的一个岛，并把值改为2，并把1旁边的0收集起来
  public static void dfs(int[][] A, Queue<int[]> queue, int i, int j, int m, int n, int[] direct, boolean[][] visited) {
    for (int k = 0; k < 4; k++) {
      int x = i + direct[k], y = j + direct[k+1];
      if (x >= 0 && x < m && y >=0 && y < n ) {
        if (A[x][y] == 1) {
          A[x][y] = 2;
          dfs(A, queue, x, y, m, n, direct, visited);
        } else if (A[x][y] == 0 && !visited[x][y]) {
          queue.offer(new int[]{x, y});
          visited[x][y] = true;
        }
      }
    }
  }

}

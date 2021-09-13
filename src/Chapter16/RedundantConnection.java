
package Chapter16;

import java.util.Arrays;

/**
 * No.684 冗余连接
 *
 * 在无向图找出一条边，移除它之后该图能够成为一棵树（即无向无环图）。
 * 如果有多个解，返回在原数组中位置最靠后的那条边。
 *
 * 题解：这道题是一个典型的并查集
 * 如果所要插入的这两个结点已经相连了，那么就说明要插入的这条边是冗余的
 */
public class RedundantConnection {

  public static void main(String[] args) {
    int[][] edges = {{1,2}, {1,3},{2,3}};
    int[] ans = findRedundantConnections(edges);
    System.out.println(Arrays.toString(ans));
  }

  public static int[] findRedundantConnections(int[][] edges) {
    int n = edges.length;
    UfTree ufTree = new UfTree(n);

    for (int i = 0; i < n; i++) {
      int p = edges[i][0] - 1;
      int q = edges[i][1] - 1;

      if (ufTree.isConnected(p, q)) {
        return edges[i];
      }
      ufTree.union(p, q);
    }
    return new int[0];
  }

}


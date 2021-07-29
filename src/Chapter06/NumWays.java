
package Chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * No.LCP 07 传递消息
 */
public class NumWays {

  public static void main(String[] args) {
    int[][] relation = {{0,2}, {2,1}, {3,4},{2,3}, {1,4}, {2,0},{0,4}};
    System.out.println(numWays2(5, relation, 3));
  }

  public static int numWays(int n, int[][] relation, int k) {
    List<List<Integer>> following = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      following.add(new ArrayList<>());
    }

    for (int[] ints : relation) {
      following.get(ints[0]).add(ints[1]);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    backtracking(n, following, k, res, path, 0, 0);
    return res.size();

  }

  public static void backtracking(int n, List<List<Integer>> following, int k, List<List<Integer>> res, List<Integer> path, int level, int curr) {
    if (level == k && curr == n-1) {
      res.add(new ArrayList<>(path));
      return;
    }
    if (level < k) {
      List<Integer> nexts = following.get(curr);
      for (int next : nexts) {
        path.add(next);
        backtracking(n, following, k, res, path, level+1, next);
        path.remove(path.size()-1);
      }
    }
  }


  // 动态规划
  public static int numWays2(int n, int[][] relation, int k) {
    // dp[i][j]表示经过i轮到第j个玩家手中
    int[][] dp = new int[k+1][n];
    dp[0][0] = 1;
    for (int i = 0; i < k; i++) {
      for (int[] egde : relation) {
        int src = egde[0], dst = egde[1];
        // 那么如果i+1轮到达dst的方案数等于第i轮到达src的方案数之和
        // 动态方程为：
        dp[i+1][dst] += dp[i][src];
      }
    }
    return dp[k][n-1];
  }

}

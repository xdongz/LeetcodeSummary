package Chapter07;

import java.util.Arrays;

/**
 * No.1049 最后一块石头的重量||
 *
 * 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 今天又是死在动态规划的一天。。。。。==！
 * 其实这一题和昨天做的No.494有异曲同工之妙，可惜没想出来
 */
public class LastStoneWeightII {

  public static void main(String[] args) {
    int[] stones = {31,26,33,21,40};
    System.out.println(lastStoneWeightII(stones));
  }

  public static int lastStoneWeightII(int[] stones) {
    // 两个石头被粉碎，其实就是一个石头减去另一个石头的重量
    // 那么这道题可以转换成在一些石头前面加负号，另一些前面加正号，使得他们的总和最小
    // 假设添加负号的石头总重量为neg，那么粉碎后的石头总重量为 sum-2*neg
    // neg<=sum/2的情况下，neg越大越好
    // dp[i][j]表示遍历到第i个石头时，总重量是否可能为j
    int sum = Arrays.stream(stones).sum(), n = stones.length;
    boolean[][] dp = new boolean[n+1][sum/2+1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= sum/2; j++) {
        if (stones[i-1] > j) {
          dp[i][j] = dp[i-1][j];
        } else {
          dp[i][j] = dp[i-1][j] || dp[i-1][j-stones[i-1]];
        }
      }
    }
    for (int i = sum/2; i >= 0; i--) {
      if (dp[n][i]) {
        return sum - 2*i;
      }
    }
    return sum;
  }

}

package Chapter07;

import java.util.Arrays;

/**
 * No.188 买卖股票的最佳时机IV
 *
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 注意： 这道题把买和卖算作一次交易
 */
public class BestTimeII {

  public static void main(String[] args) {
    int[] prices = {3,3,5,0,0,3,1,4};
    System.out.println(maxProfit(2, prices));
  }

  public static int maxProfit(int k, int[] prices) {
    int n = prices.length;

    if (n == 0) {
      return 0;
    }
    k = Math.min(k, n / 2);
    // buy[i][j] 表示第i天完成第j次交易之后但最后一步是买入的最大利润
    // sell[i][j] 表示第i天完成第j次交易之后但最后一步是卖出的最大利润
    int[][] buy  = new int[n+1][k+1];
    int[][] sell  = new int[n+1][k+1];

    // 注意初始值
    for (int[] b : buy) {
      Arrays.fill(b, Integer.MIN_VALUE);
    }
    for (int[] s : sell) {
      Arrays.fill(s, 0);
    }
    for (int i = 1; i < n+1; i++) {
      for (int j = 1; j < k+1; j++) {
        buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j-1] - prices[i-1]);
        sell[i][j] = Math.max(sell[i-1][j], buy[i][j] + prices[i-1]);
      }
    }
    return sell[n][k];
  }

  // 一维
  public static int method2(int k, int[] prices) {
    int n = prices.length;
    // 不能进行一次买卖
    if (n < 2) {
      return 0;
    }
    // 可交易次数大于天数，那么变成了121题的做法
    if (k >= n) {
      int maxProfit = 0;
      for (int i = 1; i < n; ++i) {
        if (prices[i] > prices[i-1]) {
          maxProfit += prices[i] - prices[i-1];
        }
      }
      return maxProfit;
    }

    int[] buy = new int[k+1];
    int[] sell = new int[k+1];

    Arrays.fill(buy, Integer.MIN_VALUE / 2);
    Arrays.fill(sell, 0);

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < k+1; j++) {
        // 买入不看做一次交易，卖出看作一次交易
        buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
        sell[j] = Math.max(sell[j], buy[j] + prices[i]);
      }
    }
    return sell[k];
  }


}

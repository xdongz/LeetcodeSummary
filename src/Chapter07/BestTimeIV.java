package Chapter07;

/**
 * No.714 买卖股票的最佳时机含手续费
 *
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 *
 */
public class BestTimeIV {

  public static void main(String[] args) {
    int[] prices = {1,3,2,8,4,9};
    System.out.println(method2(prices, 2));
  }

  public static int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int[] buy = new int[n];
    int[] sell = new int[n];

    buy[0] = -prices[0];
    sell[0] = 0;
    for (int i = 1; i < n; i++) {
      buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
      sell[i] = Math.max(sell[i-1], buy[i] + prices[i] - fee);
    }

    return sell[n-1];
  }

  // 降维
  public static int method2(int[] prices, int fee) {
    int n = prices.length;
    int buy = -prices[0];
    int sell = 0;

    for (int i = 1; i < n; i++) {
      buy = Math.max(buy, sell - prices[i]);
      sell = Math.max(sell, buy + prices[i] - fee);
    }

    return sell;
  }

}

package Chapter07;

/**
 * No.121 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 对于位置i来讲，此时的收益最大值为（当前股票的价格）-（0-i天中的最低价格）
 * 所以需要有一个变量记录0-i天中的最低价格，另一个变量记录最大利润即可。
 */
public class BestTimeToBuyAndSellStocks {

  public static void main(String[] args) {
    int[] prices = {7,6,4,3,1};
    System.out.println(maxProfit(prices));
  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0, minValue = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > minValue) {
        maxProfit = Math.max(prices[i] - minValue, maxProfit);
      } else {
        minValue = prices[i];
      }
    }
    return maxProfit;
  }

}

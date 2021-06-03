package Chapter07;

/**
 * No.309 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * g1: 最后一个操作是卖出股票后的冷冻期的最大利润
 * buy：最后一个操作是买入股票后的最大利润
 * g2：最后一个操作是买入股票后的冷冻期的最大利润
 * sell: 最后一个操作是卖出股票后的最大利润
 */
public class BestTimeIII {

    public static void main(String[] args) {
        int[] prices = {6,1,3,2,4,7};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int g1 = 0;
        int g2 = Integer.MIN_VALUE;

        for (int i = 1; i < n+1; i++) {
            g2 = Math.max(g2, buy);
            buy = Math.max(buy, g1 - prices[i-1]);
            g1 = Math.max(sell, g1);
            sell = g2 + prices[i-1];
        }
        return Math.max(sell, g1);
    }
}

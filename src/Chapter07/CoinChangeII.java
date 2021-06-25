package Chapter07;

public class CoinChangeII {

  public static void main(String[] args) {
    int[] coins = {3,5,7,8,9,10,11};
    System.out.println(change2(500, coins));
    System.out.println(change(500, coins));
  }


  // 方法一：用动态规划
  public static int change(int amount, int[] coins) {
    int n = coins.length;
    int[] dp = new int[amount+1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int j = coin; j <= amount; j++) {
        dp[j] = dp[j] + dp[j - coin];
      }
    }

    return dp[amount];
  }

  // 方法二：用回溯（超时了）
  public static int change2(int amount, int[] coins) {
    return backtracking(coins, amount, 0, 0);

  }

  public static int backtracking(int[] coins, int amount, int count, int level) {
    if (amount == 0) {
      count++;
      return count;
    } else if (amount < 0) {
      return 0;
    }

    for (int i = level; i < coins.length; i++) {
      amount = amount - coins[i];
      count += backtracking(coins, amount, 0, i);
      amount = amount + coins[i];
    }
    return count;
  }

}

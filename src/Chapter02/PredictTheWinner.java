package Chapter02;

/**
 * No. 486 预测赢家
 *
 * 这道题的动态规划题解没完全看懂，下次再看
 */
public class PredictTheWinner {

  public static void main(String[] args) {
    int[] nums = {0};
    System.out.println(PredictTheWinner(nums));
  }

  public static boolean PredictTheWinner(int[] nums) {

    if (nums.length % 2 == 0) {
      return true;
    }

    int n = nums.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = nums[i];
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
      }
    }
    return dp[0][n - 1] >= 0;

  }

}

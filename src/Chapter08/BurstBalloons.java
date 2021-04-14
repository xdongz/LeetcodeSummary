
package Chapter08;

/**
 * No.312 戳气球
 *
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 解题思路：采用动态规划，反过来想，将戳气球想成在两个气球之间加气球。
 *
 * 动态方程为dp[i][j] = max(val[i] * val[k] * val[j] + dp[i][k] + dp[k][j])
 * dp[i][j]表示范围(i,j)中填满数字后能获得的最多硬币数
 * 初始化dp为0
 */
public class BurstBalloons {

  public static void main(String[] args) {
    int[] nums = {3,1,5,8};
    System.out.println(maxCoins(nums));
  }

  public static int maxCoins(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n + 2][n + 2];
    int[] val = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      val[i] = nums[i - 1];
    }
    val[0] = val[n + 1] = 1;
    // 注意动态规划的遍历顺序
    // 可以这么想： 最后要求的是i=0和j=n+1时对应的dp数组中的数，所以i应该从后往前遍历，j应该从前往后遍历。
    for (int i = n + 1; i >= 0; i--) {
      for (int j = i + 2; j < n + 2 ; j++) {
        for (int k = i + 1; k < j; k++) {
          int sum = val[i] * val[k] * val[j] + dp[i][k] + dp[k][j];
          dp[i][j] = Math.max(dp[i][j], sum);
        }
      }
    }
    return dp[0][n+1];
  }

}

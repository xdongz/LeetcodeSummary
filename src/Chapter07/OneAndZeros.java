
package Chapter07;

import java.util.Arrays;

/**
 * No.474 一和零
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 此题和0-1背包问题差不多，只不过将原来的一维体积，变成了二维的0和1的个数
 *
 */
public class OneAndZeros {

  public static void main(String[] args) {
    String[] strs = {"10", "0", "1"};
    System.out.println(findMaxForm(strs, 1, 1));
  }

  public static int findMaxForm(String[] strs, int m, int n) {
    int len = strs.length;
    int[][] dp = new int[m+1][n+1];

    for (int[] d : dp) {
      Arrays.fill(d, 0);
    }
    for (int i = 1; i < len+1; i++) {
      String word = strs[i-1];
      int[] count = oneZero(word);
      for (int j = m; j >= count[0]; j--) {
        for (int k = n; k >= count[1] ; k--) {
          dp[j][k] = Math.max(dp[j][k], dp[j-count[0]][k-count[1]] + 1);
        }

      }
    }
    return dp[m][n];
  }

  public static int[] oneZero(String word){
    int zero = 0, one = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == '0') {
        zero++;
      } else {
        one++;
      }
    }
    return new int[]{zero, one};
  }

}

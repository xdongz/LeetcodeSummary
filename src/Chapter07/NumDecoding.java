
package Chapter07;

/**
 * No.91 解码方法
 *
 * 已知字母A-Z 可以表示成数字1-26。给定一个数字串，求有多少种不同的字符串等价于这个数字串。
 *
 * 这题不难，就是需要细心，考虑到各种情况
 * dp[i]表示到下标i时有多少种映射方法
 */
public class NumDecoding {

  public static void main(String[] args) {
    String s = "2611055971756562";
    System.out.println(numDecoding(s));
  }

  public static int numDecoding(String s) {
    int n = s.length();
    int[] dp = new int[n];

    dp[0] = s.charAt(0) == '0' ? 0 : 1;

    if (n == 1) {
      return dp[0];
    }

    for (int i = 1; i < n; i++) {
      char ch = s.charAt(i);
      char prev = s.charAt(i-1);
      if (ch >= '1' && ch <= '9') {
        if ((ch > '6'&& prev > '1') || prev > '2' || prev == '0') {
          dp[i] = dp[i-1];
        } else {
          if (i == 1) {
            dp[i] = dp[i-1] + 1;
          } else {
            dp[i] = dp[i - 1] + dp[i - 2];
          }
        }
      } else if (ch == '0' && prev > '2' || prev == '0') {
        // 如果中途发现有字符不能映射，就直接返回0
        return 0;
      } else {
        dp[i] = i == 1? 1 : dp[i-2];
      }
    }
    return dp[n-1];
  }

}

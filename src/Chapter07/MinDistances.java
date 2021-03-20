package Chapter07;

/**
 * No.583 两个字符串的删除操作
 *
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 此题和72题EditDist一样，就不赘述了
 */
public class MinDistances {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        System.out.println(minDistance(word1, word2));
    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
           dp[i][0] = i;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m+1; i++) {
            char ch1 = word1.charAt(i-1);
            for (int j = 1; j < n+1; j++) {
               char ch2 = word2.charAt(j-1);
               if (ch1 == ch2) {
                   dp[i][j] = dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
               }
            }
        }
        return dp[m][n];
    }
}

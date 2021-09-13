package Chapter07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No.646 最长对数链
 * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 动态规划，和最长递增子序列的解法差不多
 */
public class LongestChain {
    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int[] num1 = pairs[i];
            for (int j = 0; j < i; j++) {
                int[] num2 = pairs[j];
                if (num1[0] > num2[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }
}

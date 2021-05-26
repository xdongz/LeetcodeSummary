/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter07;

/**
 * No.1035 不相交的线
 *
 * 动态规划可以保证不相交，因为新加进来的(i,j)和之前加入的线段顺序是一致的。
 */
public class MaxUncrossedLines {

  public static void main(String[] args) {
    int[] nums1 = {1,4,2};
    int[] nums2 = {1,2,4};
    System.out.println(maxUncrossedLines(nums1, nums2));
  }
  public static int maxUncrossedLines(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int[][] dp = new int[m+1][n+1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (nums1[i-1] == nums2[j-1]) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[m][n];
  }

}

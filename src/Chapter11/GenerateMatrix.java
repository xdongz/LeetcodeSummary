/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.Arrays;

/**
 * No. 59 螺旋矩阵||
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 此题和第54题SpiralOrder解题方法类似
 */
public class GenerateMatrix {

  public static void main(String[] args) {
    int[][] ans = generateMatrix(3);
    for (int[] a : ans) {
      System.out.println(Arrays.toString(a));
    }
  }

  public static int[][] generateMatrix(int n) {
    int[][] ans = new int[n][n];
    recursion(ans, 0, n, 1);

    return ans;
  }

  public static void recursion(int[][] ans, int ln, int rn, int start) {
    if (ln >= rn) {
      return;
    }
    for (int i = ln; i < rn; i++) {
      ans[ln][i] = start;
      start ++;
    }

    for (int i = ln + 1; i < rn; i++) {
      ans[i][rn-1] = start;
      start ++;
    }

    for (int i = rn - 2; i >= ln; i--) {
      ans[rn - 1][i] = start;
      start ++;
    }

    for (int i = rn - 2; i > ln ; i--) {
      ans[i][ln] = start;
      start ++;
    }
    recursion(ans, ln + 1, rn - 1, start);
  }

}

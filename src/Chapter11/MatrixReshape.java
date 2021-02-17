/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

/**
 * No.566 重塑矩阵
 *
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 */
public class MatrixReshape {

  public static void main(String[] args) {
    int[][] nums = {{1,2}, {3,4}};
    int r = 1, c = 4;
    matrixReshape(nums, 1, 4);
  }

  /**
   * 把矩阵ans和nums都展开成一维矩阵，那么他们对应的元素值肯定相等
   * 下标为(i,j)元素会变成下表为 i*n + j的元素
   * 所以对于一维矩阵中同一个下表x，对应的ans中下标为(x/c, x%c)的元素，对应nums中下标为(x/n, x%n)的元素
   * 所以ans[i/c][i%c] = nums[i/n][i%n]
   *
   */
  public static int[][] matrixReshape(int[][] nums, int r, int c) {
    int m = nums.length, n = nums[0].length;
    if (m * n != r * c) {
      return nums;
    }

    int[][] ans = new int[r][c];
    for (int i = 0; i < c * r; i++) {
      ans[i/c][i%c] = nums[i/n][i%n];
    }
    return ans;
  }
}

/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

/**
 * No. 48
 * 旋转图像，给定一个n * n的二维矩阵matrix表示一个图像，请你将图像顺时针旋转90度
 * 这道题的难点在于： 不能使用另一个矩阵来旋转图像
 */
public class rotate {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    //关键在于如何确定i和j的取值范围，因为同样的位置不能重复旋转
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - 1 - i; j++) {
        int temp = matrix[n - 1 -j][i];
        matrix[n - 1 -j][i] = matrix[n - 1 -i][n - 1 - j];
        matrix[n - 1 -i][n - 1 - j] = matrix[j][n - 1 -i];
        matrix[j][n - 1 -i] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
  }

}

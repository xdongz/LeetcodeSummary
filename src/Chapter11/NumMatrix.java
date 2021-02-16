/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

/**
 * No.304
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * 利用前缀和。新建一个矩阵，算出matrix中所有位置对应的前缀和。
 */
public class NumMatrix {

  private int[][] integrity;
  private int[][] matrix;

  public NumMatrix(int[][] matrix) {
    this.matrix = matrix;
    int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
    integrity = new int[m][n];
    for (int i = 0; i < m ; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          integrity[i][j] = matrix[i][j];
        } else if (i == 0) {
          integrity[i][j] = matrix[i][j] + integrity[i][j-1];
        } else if (j == 0) {
          integrity[i][j] = matrix[i][j] + integrity[i-1][j];
        } else {
          integrity[i][j] =
              matrix[i][j] + integrity[i - 1][j] + integrity[i][j - 1] - integrity[i - 1][j - 1];
        }
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2){
    int ans = 0;
    if (col1 > 0 && row1 > 0) {
      ans =
          integrity[row2][col2] - integrity[row2][col1 - 1] - integrity[row1 - 1][col2] + integrity[
              row1 - 1][col1 - 1];
    } else if (col1 == 0 && row1 == 0) {
      ans = integrity[row2][col2];
    } else if (col1 == 0) {
      ans = integrity[row2][col2] - integrity[row1 - 1][col2];
    } else if (row1 == 0) {
      ans = integrity[row2][col2] - integrity[row2][col1 - 1];
    }
    return ans;
  }

}

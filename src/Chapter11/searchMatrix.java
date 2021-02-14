/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

/**
 * No.240
 * 给定一个二维矩阵，已知每行和每列都是增序的，尝试设计一个快速搜索一个数字是否在矩阵中存在的算法。
 *
 * 这道题的一个比较简单的思路是，从矩阵的右上角出发，与target比较，如果比target大，就向左移一步
 * 如果比target小，就向右移动一步，直到到达左下角。从左下角出发亦可
 * 其实可以看作一个二叉树，但是左右两个子节点必须一个大于父节点一个小于父节点
 */
public class searchMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int i = n - 1, j = 0;
    while (i >= 0 && j < m) {
      if (matrix[j][i] >  target) {
        i --;
      } else if (matrix[j][i] < target) {
        j ++;
      } else {
        return true;
      }
    }
    return false;
  }
}

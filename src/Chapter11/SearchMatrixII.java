/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

public class SearchMatrixII {

  public static void main(String[] args) {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    //int[][] matrix = {{1}};
    int target = 0;
    System.out.println(searchMatrix(matrix, target));
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    // 先对行进行二分查找
    int l = -1, r = m-1;
    while (l < r) {
      int mid = (l+r+1) / 2;
      if (matrix[mid][0] == target) {
        return true;
      } else if (matrix[mid][0] < target) {
        l = mid;
      } else {
        r = mid-1;
      }
    }
    int row = l;

    if (row < 0) {
      return false;
    }

    // 对列进行二分查找
    l = -1; r = n-1;
    while (l < r) {
      int mid = (l+r+1) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        l = mid;
      } else {
        r = mid-1;
      }
    }
    return false;
  }

}

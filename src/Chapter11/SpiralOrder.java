
package Chapter11;

import java.util.ArrayList;
import java.util.List;

/**
 * No. 54 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 解题思路： 递归，先输出最外层的元素，然后将矩阵缩小，再输出最外层的元素。。。。
 */
public class SpiralOrder {

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    System.out.println(spiralOrder(matrix));
  }
  public static List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;

    List<Integer> ans = new ArrayList<>();
    recur(matrix, ans, 0, m, 0, n);
    return ans;
  }

  public static void recur(int[][] matrix, List<Integer> ans, int lm, int rm , int ln, int rn) {
    if (ln >= rn || lm >= rm) {
      return;
    }
    for (int j = ln; j < rn; j++) {
      ans.add(matrix[lm][j]);
    }

    for (int i = lm + 1; i < rm; i++) {
      ans.add(matrix[i][rn-1]);
    }

    if (rm - 1 > lm) {
      for (int j = rn - 2; j >= ln ; j--) {
        ans.add(matrix[rm - 1][j]);
      }
    }

    if (ln < rn - 1) {
      for (int i = rm - 2; i > lm ; i--) {
        ans.add(matrix[i][ln]);
      }
    }
    recur(matrix, ans, lm + 1, rm - 1, ln + 1, rn - 1);
  }

}

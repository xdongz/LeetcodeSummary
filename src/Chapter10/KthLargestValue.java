
package Chapter10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestValue {

  public static void main(String[] args) {
    int[][] matrix = {{5,2}, {1,6}};
    System.out.println(kthLargestValue(matrix, 4));
  }

  public static int kthLargestValue(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int[][] preSum = new int[m][n];

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          if (j > 0) {
            preSum[i][j] = preSum[i][j - 1] ^ matrix[i][j];
          } else {
            preSum[i][j] = matrix[i][j];
          }
        } else if (j == 0) {
          preSum[i][j] = preSum[i-1][j] ^ matrix[i][j];
        } else {
          preSum[i][j] = preSum[i-1][j] ^ preSum[i][j-1] ^ preSum[i-1][j-1] ^ matrix[i][j];
        }
        priorityQueue.add(preSum[i][j]);
      }
    }

    int res = 0;
    for (int i = 0; i < k; i++) {
      res = priorityQueue.poll();
    }
    return res;
  }

}

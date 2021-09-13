
package Chapter08;

import java.util.Arrays;

/**
 * No.923 三数之和的多种可能
 *
 * 给定一个整数数组A，以及一个整数target作为目标值，返回满足 i < j < k 且A[i] + A[j] + A[k] == target的元组i, j, k的数量。
 *
 * 解题思路：
 * 若对一个有序数组，查找两个值等于target，那么我们可以分别在头和尾放一个指针，如果两数之和大于target，则后一个指针向前移动一位，否则，前一个指针向后移动一位
 *
 * 那么对于此题来说，也可以先给数组排序，排序并不会影响最后的结果
 * 对于数组中的每个元素i，需要找有序数组arr[i+1, n-1]中两数之和等于target-arr[i]有多少种可能性
 */
public class ThreeSumMulti {

  public static void main(String[] args) {
    int[] arr = {1,1,2,2,3,3,4,4,5,5};
    int target = 8;
    System.out.println(threeSumMulti(arr, target));
  }

  public static int threeSumMulti(int[] arr, int target) {
    int count = 0;
    int MOD = (int)Math.pow(10, 9) + 7;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      int j = i + 1, k = arr.length - 1;
      int T = target - arr[i];

      while (j < k) {
        if (arr[j] + arr[k] < T) {
          j ++;
        } else if (arr[j] + arr[k] > T) {
          k --;
          // 如果arr[j] + arr[k] == T，但arr[j] != arr[k]
          // 那么他们的组合个数是arr[j]的个数乘以arr[k]的个数
        } else if (arr[j] != arr[k]) {
          int jNums = 1;
          int kNums = 1;
          while (j + 1 < k && arr[j] == arr[j + 1]) {
            jNums ++;
            j ++;
          }
          while (k - 1 > j && arr[k] == arr[k - 1]) {
            kNums ++;
            k --;
          }
          j ++;
          k --;
          count += jNums * kNums;
          count %= MOD;
        } else {
          // 长度是k-j+1，那么可能的取值就是Cn2(排列组合)，也就是n*(n-1)/2
          count += (k - j + 1) * (k - j) / 2;
          count %= MOD;
          break;
        }
      }
    }
    return count;
  }

}

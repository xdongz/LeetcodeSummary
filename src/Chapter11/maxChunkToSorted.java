
package Chapter11;

/**
 * No. 769
 * 给定一个含有0 到n 整数的数组，每个整数只出现一次，求这个数组最多可以分割成多少个
 * 子数组，使得对每个子数组进行增序排序后，原数组也是增序的。
 */
public class maxChunkToSorted {

  public static void main(String[] args) {
    int[] arr = {4,3,2,1,0};
    System.out.println(maxChunkToSorted(arr));
  }

  /**
   * 这道题的思路很巧妙。如果排好序了，那么数字i肯定在索引为i的位置上
   * 遍历数组，假设遍历到i，如果位置i之前的最大值比i大，那么就说明i之后肯定有比这个最大值小的数
   * 这些小的数也需要加入到子数组中来
   * 又因为数组只包含不重复的0 到n，所以当前最大值一定不会小于数组位置。
   * 所以每当当前最大值等于数组位置时，假设为p，我们可以成功完成一次分割，并且其与上一次分割位置q 之间的值一定是q + 1 到p 的所有数
   *
   * @param arr 输入的数组
   * @return 返回最多分成的子数组数量
   */
  public static int maxChunkToSorted(int[] arr) {
    int n = arr.length, count = 0, max = 0;

    for (int i = 0; i < n; i++) {
      max = Math.max(arr[i], max);
      if (max == i) {
        count ++;
      }
    }
    return count;
  }
}

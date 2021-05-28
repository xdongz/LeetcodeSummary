
package Chapter10;

/**
 * No. 477 汉明距离总和
 *
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 解题思路：逐位运算，如果某一位中0的个数是c，1的个数是(n-c),那么该位上不同的距离之和为c*(n-c)
 */
public class TotalHammingDist {

  public static void main(String[] args) {
    int[] nums = {4,14,2};
    System.out.println(totalHammingDistance(nums));
  }

  public static int totalHammingDistance(int[] nums) {
    int ans = 0, n = nums.length;
    for (int i = 0; i < 30; i++) {
      // 0的个数
      int c = 0;
      for (int val : nums) {
        val = val >> i;
        if ((val & 1) == 0) {
          c ++;
        }
      }
      ans += c * (n-c);
    }
    return ans;
  }



}

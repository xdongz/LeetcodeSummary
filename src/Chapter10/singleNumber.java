
package Chapter10;

/**
 * No.136
 * 求一个非空数组中只出现一次的元素，其余的每个元素均出现两次
 *
 * 一个最简单的办法就是，两个相同的数字异或是0，而0与任何数字异或都是该数字
 */
public class singleNumber {

  public int singleNumber(int[] nums) {

    int ans = 0;
    for (int n : nums) {
      ans = ans ^ n;
    }
    return ans;

  }

}

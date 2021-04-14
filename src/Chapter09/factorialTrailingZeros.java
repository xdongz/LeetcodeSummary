
package Chapter09;

/**
 * 输入一个非负整数，求这个非负整数的阶乘尾部有多少个0
 * No.172
 */
public class factorialTrailingZeros {

  /**
   * 本题最关键的地方就是想出尾部的0是由2*5来的，所以可以转化成1..n可以分解成多少个2和5
   * 而2的倍数绝对会比5的倍数多，所以本题只用看可以分解成多少个5
   * 5，10，15，20中有一个5因子，而25中有2个5因子...
   * 所以5的因子的个数可以表示成: n/5 + n/(5*5) + n / (5*5*5) + ...
   *
   * @param n 输入的非负整数
   * @return 输出n!尾部有多少个0
   */
  public int trailingZeros(int n) {
    if (n == 0) {
      return 0;
    }
    return n / 5 + trailingZeros(n / 5);
  }

}

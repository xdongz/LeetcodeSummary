
package Chapter10;

/**
 * No.191 位的个数
 *
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */
public class HammingWeight {

  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n &= (n-1);
      count++;
    }
    return count;
  }

}

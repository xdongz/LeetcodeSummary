
package Chapter10;

/**
 * No.461
 * 计算两个数字对应的二进制位不同位置的数目
 *
 * 这道题很简单，就是两个数异或，需要注意的是如果计算一个数的二进制表示中有多少个1
 * 这个计算方式和之前做的七进制转换有一点像
 */
public class hammingDist {

  public int hammingDistance(int x, int y) {
    int diff = x ^ y;
    int ans = 0;

    while (diff > 0) {
      //按位与，最后一位是1，那么就是1，否则是0
      ans += diff & 1;
      diff = diff >> 1;
    }
    return ans;
  }

}

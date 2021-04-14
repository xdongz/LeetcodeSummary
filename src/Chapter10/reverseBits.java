
package Chapter10;

/**
 * No.190
 * 颠倒32位无符号整数的二进制位。
 * 和hammingDist的思路一样
 */
public class reverseBits {

  public static void main(String[] args) {
    System.out.println(reverseBits(43261596));
  }

  public static int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      int ans = n & 1;
      res = (res << 1) + ans;
      n = n >> 1;
    }
    return res;
  }

}

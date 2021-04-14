
package Chapter10;

/**
 * No.693
 * 判断一个数的二进制表示是否是0，1交替的
 */
public class alternatingBits {

  public static void main(String[] args) {
    System.out.println(hasAlternatingBits(3));
  }

  public static boolean hasAlternatingBits(int n) {
    //一步一步地判断相邻两位是否相等
    while (n > 0) {
      if (((n & 1) ^ ((n >> 1) & 1)) == 0) {
        return false;
      }
      n = n >> 1;
    }
    return true;
  }

  public static boolean method2(int n) {
    //如果n是错位的，那么n ^ (n >> 1)为全1，加1之后就变成最高位为1，其余为0的数字了
    int ans = (n ^ (n >> 1)) + 1;
    //根据n & (n - 1) 可以去掉最低位的1来看，那么这样得到的值会是0(如果n是错位的)
    return ((ans & (ans -1)) == 0);
  }
}


package Chapter04;

/**
 * No. 69 x的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 从1到x，二分查找
 */
public class Sqrt {

  public static void main(String[] args) {
    System.out.println(mySqrt(5));
  }

  public static int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    int l = 1, r = x, mid, ans = 1;
    // 这里需要是小于等于，因为有可能二分后，r*r也小于x了
    while (l <= r) {
      mid = (l + r) / 2;
      if (x / mid == mid) {
        return mid;
      } else if (x / mid < mid) {
        r  = mid - 1;
      } else {
        ans = mid;
        l = mid + 1;
      }
    }
    return ans;
  }

}

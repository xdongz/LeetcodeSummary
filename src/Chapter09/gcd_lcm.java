
package Chapter09;

//本类存储着最大公约数和最小公倍数的解法
public class gcd_lcm {

  //求最大公约数
  //辗转相除法： 如果一个数是a和b的公约数，那么这个数也会是a%b 和 b的公约数，就转换成了b和a%b的最大公约数问题
  //而且a%b肯定小于b，所以用递归便很容易求出最大公约数
  public int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  //最小公倍数
  //两个数相乘再除以两个数的最大公约数就是最小公倍数
  public int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

}


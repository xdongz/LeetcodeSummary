
package Chapter15;

public class IsPalindrome {

  public static void main(String[] args) {
    System.out.println(method2(100));
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    String s = String.valueOf(x);
    int l = 0, r = s.length()-1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }

    return true;
  }

  // 方法二：不适用字符串，翻转一半的数字
  public static boolean method2(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;

    int revNum = 0;
    while (x > revNum) {
      revNum = revNum * 10 + x % 10;
      x = x / 10;
    }

    return x == revNum || x == revNum / 10;

  }

}

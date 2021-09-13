package Chapter12;

/**
 * No. 1221 分割平衡字符串
 */
public class BalancedStringSplit {
  public static void main(String[] args) {
    String s = "RLRRLLRLRL";
    System.out.println(balancedStringSplit(s));
  }

  public static int balancedStringSplit(String s) {
    int n = s.length();
    int l = 0, r = 1, sum = 0;
    int count = s.charAt(0) == 'R' ? 1 : -1;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == 'R') {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        sum++;
      }
    }
    return sum;
  }
}

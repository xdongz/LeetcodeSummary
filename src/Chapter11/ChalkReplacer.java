package Chapter11;

/**
 * No. 1894 找到需要补充粉笔的学生编号
 *
 * 很简单，就是要防止溢出
 */
public class ChalkReplacer {
  public static void main(String[] args) {
    int[] chalk = {22,25,39,3,45,45,12,17,32,9};
    int k = 835;
    System.out.println(chalkReplacer(chalk, k));
  }
  public static int chalkReplacer(int[] chalk, int k) {
    int n = chalk.length;
    long total = 0;
    for (int i = 0; i < n; i++) {
      total += chalk[i];
    }
    k %= total;
    for (int i = 0; i < n; i++) {
      if (k < chalk[i]) {
        return i;
      } else {
        k -= chalk[i];
      }
    }
    return n-1;
  }
}

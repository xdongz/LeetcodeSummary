
package Chapter12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.1006 笨阶乘
 *
 * 笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 */
public class Clumsy {

  public static void main(String[] args) {
    System.out.println(clumsy(1));
  }

  public static int clumsy(int N) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(N);
    int j = 1;
    for (int i = N-1; i > 0 ; i--) {
      if (j % 4 == 1) {
        int num = stack.pop();
        num = num * i;
        stack.push(num);
      } else if (j % 4 == 2) {
        int num = stack.pop();
        num = num / i;
        stack.push(num);
      } else if (j % 4 == 3) {
        stack.push(i);
      } else if (j % 4 == 0) {
        stack.push(-i);
      }
      j++;
    }
    int res = 0;
    while (!stack.isEmpty()) {
      res += stack.pop();
    }
    return res;
  }
}

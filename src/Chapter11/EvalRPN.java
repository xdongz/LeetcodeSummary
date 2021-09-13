package Chapter11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.150 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 此题很简单，用栈做，就不赘述了
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};

        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                int num = Integer.parseInt(s);
                stack.push(num);
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (s.equals("+")) {
                    stack.push(num1 + num2);
                } else if (s.equals("-")) {
                    stack.push(num2 - num1);
                } else if (s.equals("*")) {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }
}

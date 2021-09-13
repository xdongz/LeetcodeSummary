
package Chapter11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 *
 * 遇到有效括号这样的题，应首先想到栈
 * 因为此题中只有括号，所以只要遇到反括号，那么就弹出栈顶元素看是否与之对应，不对应就返回false
 * 需要注意的是 s = "[" 或者s = "]"这样的特殊情况
 */
public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("]"));
  }

  public static boolean isValid(String s) {
    Deque<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (c == ')') {
        if (stack.isEmpty() || stack.pop() != '(' ) {
          return false;
        }
      } else if (c == ']') {
        if (stack.isEmpty() || stack.pop() != '[' ) {
          return false;
        }
      } else if (c == '}') {
        if (stack.isEmpty() || stack.pop() != '{' ) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}

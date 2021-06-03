package Chapter11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.394 字符串解码
 *
 * 一个更好的方法是：数字放在数字栈，字符放在字符栈
 */
public class DecodeString {

  public static void main(String[] args) {
    String s = "3[a2[c]]";
    System.out.println(decodeString(s));
  }

  public static String decodeString(String s) {

    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch != ']') {
        stack.push(ch);
      } else {
        StringBuilder str = new StringBuilder();
        int num = 0;
        while (stack.peek() != '[') {
          str.append(stack.pop());
        }
        stack.pop();
        int id = 0;
        while (!stack.isEmpty() && stack.peek() <= '9' && stack.peek() >= '0') {
          char ch2 = stack.pop();
          num += (ch2 - '0') * Math.pow(10, id);
          id++;
        }
        String str2 = repeat(str.toString(), num);
        for (int j = 0; j < str2.length(); j++) {
          stack.push(str2.charAt(j));
        }

      }
    }
    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()) {
      res.append(stack.removeLast());
    }

    return res.toString();
  }

  public static String repeat(String str, int num) {
    String reverse = new StringBuilder(str).reverse().toString();
    return reverse.repeat(num);
  }
}

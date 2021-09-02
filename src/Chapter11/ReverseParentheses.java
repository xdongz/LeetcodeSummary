
package Chapter11;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseParentheses {

  public static void main(String[] args) {
    String s = "a(bcdefghijkl(mno)p)q";
    System.out.println(reverseParentheses(s));
  }
  
  public static String reverseParentheses(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch != ')') {
        stack.push(ch);
      } else {
        StringBuilder temp = new StringBuilder();
        while (stack.peek() != '(') {
          temp.append(stack.pop());
        }
        stack.pop();
        for (int j = 0; j < temp.length(); j++) {
          stack.push(temp.charAt(j));
        }
      }
    }

    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()) {
      res.append(stack.removeLast());
    }
    return res.toString();
  }
  

}


package Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.241 为运算表达式设计优先级
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
 *
 * 解题思路：利用分治思想，把加括号转换为，对于每个运算符号，先执行处理两侧的数学表达式，再处理此运算符
 * 这种方法可能会计算出重复的结果。
 */
public class DiffWaysToAddParentheses {

  public static void main(String[] args) {
    String input = "2*3-4*5";
    System.out.println(Arrays.toString(diffWaysToCompute(input).toArray()));
  }

  public static List<Integer> diffWaysToCompute(String input) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*') {
        // 得出运算符左右两侧可能的结果组合
        List<Integer> left = diffWaysToCompute(input.substring(0, i));
        List<Integer> right = diffWaysToCompute(input.substring(i + 1));
        for (int l : left) {
          for (int r : right) {
            switch (ch) {
              case '+' : result.add(l + r); break;
              case '-' : result.add(l - r); break;
              case '*' : result.add(l * r); break;
            }
          }
        }
      }
    }

    // 只有数字的情况
    if (result.size() == 0) {
      result.add(Integer.valueOf(input));
    }
    return result;
  }

}

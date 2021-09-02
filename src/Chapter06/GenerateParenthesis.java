
package Chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * No.22 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 */
public class GenerateParenthesis {

  public static void main(String[] args) {
    List<String> res = generateParenthesis(3);
    System.out.println(res);
  }

  // 首先想到的是回溯
  public static List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    backtracking(res, path, 0, 0, n);
    return res;
  }

  public static void backtracking(List<String> res, StringBuilder path, int open, int close, int n) {
    if (path.length() == 2*n) {
      res.add(path.toString());
      return;
    }

    // 这两个if可以交换位置
    if (open < n) {
      path.append('(');
      backtracking(res, path, open+1, close, n);
      path.deleteCharAt(path.length()-1);
    }

    if (close < open) {
      path.append(')');
      backtracking(res, path, open, close+1, n);
      path.deleteCharAt(path.length()-1);
    }

  }

}

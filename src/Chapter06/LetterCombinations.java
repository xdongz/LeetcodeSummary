
package Chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * No.17 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 回溯。最好是用map来存储数字和对应的字母，减少if else
 *
 */
public class LetterCombinations {

  public static void main(String[] args) {
    String digits = "78";
    List<String> res = letterCombinations(digits);
    System.out.println(res);
  }

  public static List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits.length() == 0) {
      return res;
    }

    StringBuilder path = new StringBuilder();
    backtracking(digits, res, path, 0);
    return res;
  }

  public static void backtracking(String digits, List<String> res, StringBuilder path, int level) {
    if (level == digits.length()) {
      res.add(path.toString());
      return;
    }

    char currDigit = digits.charAt(level);
    int n = 3;
    if (currDigit == '7' || currDigit == '9') {
      n = 4;
    }
    for (int i = 0; i < n; i++) {
      char ch = '0';
      if (currDigit <= '7') {
        ch = (char) ('a' + (currDigit - '2') * 3 + i);
      } else if (currDigit == '8') {
        ch = (char) ('t' + i);
      } else if (currDigit == '9') {
        ch = (char) ('w' + i);
      }
      path.append(ch);
      backtracking(digits, res, path, level + 1);
      path.deleteCharAt(path.length()-1);
    }

  }

}

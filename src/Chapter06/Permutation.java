package Chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

  public static void main(String[] args) {
    String s = "aab";
    String[] permutation = permutation(s);
    System.out.println(Arrays.toString(permutation));
  }

  public static String[] permutation(String s) {

    // 1. 排序
    char[] chars = s.toCharArray();
    Arrays.sort(chars);

    // 2. 回溯
    boolean[] used = new boolean[chars.length];
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    backtracking(chars, path, res, 0, used);
    String[] ans = new String[res.size()];
    for (int i = 0; i < res.size(); i++) {
      ans[i] = res.get(i);
    }
    return ans;
  }

  public static void backtracking(char[] s, StringBuilder path, List<String> res, int level, boolean[] used) {
    if (level == s.length) {
      res.add(path.toString());
      return;
    }

    for (int i = 0; i < s.length; i++) {
      if (used[i]) {
        continue;
      }

      if (i > 0 && s[i] == s[i-1] && !used[i-1]) {
       continue;
      }

      used[i] = true;
      path.append(s[i]);
      backtracking(s, path, res, level + 1, used);
      path.deleteCharAt(path.length()-1);
      used[i] = false;
    }
  }

}


package Chapter12;

import java.util.ArrayList;
import java.util.List;

/**
 * No.696 计数二进制子串
 *
 * 给定一个0-1 字符串，求有多少非空子字符串的0 和1 数量相同。所有的0和所有的1都是连续的
 *
 * 这道题的思路很巧妙。假设有一个字符串0000111，那么它符合题意的子串应为3个。
 * 我们可以将字符串 s 按照 0和 1 的连续段分组，存在 counts数组中，
 * 例如 s = 00111011，可以得到这样的 counts 数组：counts={2,3,1,2}。
 * 这里 counts 数组中两个相邻的数一定代表的是两种不同的字符。
 * 假设 counts 数组中两个相邻的数字为 u或者 v，它们对应着 u 个 0 和 v 个 1，或者 u 个 1 和 v 个 0。
 * 它们能组成的满足条件的子串数目为 min{u,v}，
 *
 */
public class BinarySubstring {

  public static void main(String[] args) {
    String s = "00110";
    System.out.println(method2(s));
  }

  public static int countBinarySubstrings(String s) {
    List<Integer> count = new ArrayList<>();

    int temp = 0;
    int ptr = 0;
    while (ptr < s.length()) {
      char ch = s.charAt(ptr);
      while (ptr < s.length() && s.charAt(ptr) == ch){
        temp++;
        ptr++;
      }
      count.add(temp);
      temp = 0;
    }

    int ans = 0;
    System.out.println(count);
    for (int i = 1; i < count.size(); i++) {
      ans += Math.min(count.get(i-1), count.get(i));
    }
    return ans;
  }

  /**
   * 方法二是方法1的优化版
   * 从方法一可知，其实当前的字符可以有多少个子串只与上一段不同数字的连续个数有关
   * 假设有字符串 1110，对于最后一位来说，连续的相同数字个数是1，上一段不同数字的连续个数是3.
   * 由于3 > 1，所以存在一个且只存在一个以当前数字结尾的满足条件的子字符串，ans可以加1.
   */
  public static int method2(String s) {
    // prev用来保存上一段不同数字的连续个数
    // curr表示当前段的相同数字个数
    int prev = 0, cur = 1, ans = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i-1)) {
        cur++;
      } else {
        prev = cur;
        cur = 1;
      }
      //只要prev >= curr，那么就存在一个以当前数字结尾的满足条件的子串
      if (prev >= cur) {
        ans ++;
      }
    }
    return ans;
  }
}

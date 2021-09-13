
package Chapter12;

/**
 * No.647 回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 首先想到的方法便是遍历字符串看有多少个子串，然后判断这些子串是否是回文字符串
 * 但这种方法的时间复杂度是O(n^3)
 *
 * 本题采用的是中心扩展法。比如字符串”ababa"，以中间的字符a为中心，每次向左向右扩展一个字符，如果左右的字符相等，
 * 那么回文子串的数量加1.
 * 但是我们发现如果只是以单个字符为中心扩展，那么得到的子串永远都是由奇数个字符组成的字符串，有的偶数个字符串也可能是回文串啊
 * 那么除了以单个字符为中心扩散，还需要以相邻的两个字符为中心扩散
 */
public class CountSubString {

  public static void main(String[] args) {
    System.out.println(countSubstring("aaa"));
  }
  public static int countSubstring(String s ){

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      // 奇数长度
      count += extendString(s, i, i);
      // 偶数长度
      count += extendString(s, i, i+1);
    }
    return count;
  }

  public static int extendString(String s, int l, int r) {
    int count = 0;
    while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l --;
      r ++;
      count ++;
    }
    return count;
  }

}

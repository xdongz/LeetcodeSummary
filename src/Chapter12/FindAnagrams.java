package Chapter12;

import java.util.ArrayList;
import java.util.List;

/**
 * No.438 找到字符中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 首先就想到了双指针，但是如何判断s的子串和p是异位词呢？如果遍历判断每个字母的个数相等，那么复杂度太高了。
 * 一个简单的做法是当右指针对应的字母个数大于p中的个数，那么就右移左指针，随即减少对应弹出字母的个数
 */
public class FindAnagrams {

  public static void main(String[] args) {
    String s = "abab", p = "ab";
    System.out.println(findAnagrams(s, p));
  }

  public static List<Integer> findAnagrams(String s, String p) {
    int[] pCnt = new int[26];
    int[] sCnt = new int[26];
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < p.length(); i++) {
      pCnt[p.charAt(i) - 'a']++;
    }

    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      int id = s.charAt(right) - 'a';
      sCnt[id]++;
      while (sCnt[id] > pCnt[id]) {
        sCnt[s.charAt(left) - 'a']--;
        left++;
      }
      if (right - left + 1 == p.length()) {
        res.add(left);
      }
    }
    return res;
  }

}

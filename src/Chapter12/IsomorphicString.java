/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * No. 205 同构字符串
 *
 * 判断两个字符串是否同构。同构的定义是，可以通过把一个字符串的某些相同的字符转换成
 * 另一些相同的字符，使得两个字符串相同，且两种不同的字符不能够被转换成同一种字符。
 *
 * 映射的第一反映是map，本题需要构建两个map，互相映射
 *
 * 另外还有一种解法是通过数组，256个字符对应数组不同的索引，通过判断字符上一次出现的位置是否一样来判断是否为同构字符串
 * 但这种方法必须保证只能是这256个字符组成的字符串
 */
public class IsomorphicString {

  public static void main(String[] args) {
    String s = "badc";
    String t = "baba";
    System.out.println(isIsomorphic(s, t));
  }

  public static boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Character> smap = new HashMap<>();
    Map<Character, Character> tmap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if ((smap.containsKey(sChar) && smap.get(sChar) != tChar)
          || (tmap.containsKey(tChar) && tmap.get(tChar) != sChar)) {
        return false;
      }
      smap.put(sChar, tChar);
      tmap.put(tChar, sChar);
    }

    return true;
  }

  public boolean method2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] s_last_index = new int[256];
    int[] t_last_index = new int[256];
    Arrays.fill(s_last_index, 0);
    Arrays.fill(t_last_index, 0);

    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if (s_last_index[sChar] != t_last_index[tChar]) {
        return false;
      }
      s_last_index[sChar] = t_last_index[tChar] = i + 1;
    }
    return true;
  }

}

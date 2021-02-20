/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter12;

import java.util.Arrays;

/**
 * No.242 v 有效的字母异位
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 这道题的解答方法有很多种，注意时间复杂度
 */
public class ValidaAnagram {

  public static void main(String[] args) {
    String s = "rat";
    String t = "hat";
    System.out.println(isAnagram(s, t));
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      table[ch - 'a'] ++;
    }

    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      table[ch - 'a'] --;
      if (table[ch - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public boolean method2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    Arrays.sort(sArray);
    Arrays.sort(tArray);
    return Arrays.equals(sArray, tArray);
  }
}

/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter12;

/**
 * No.28 实现strStr()
 *
 * 实现strStr()函数。
 *
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 这里只列出了最简单的暴力算法，还有一种效率更高的KMP算法。
 *
 */
public class StrStr {

  public static void main(String[] args) {
    String haystack = "", needle = "";
    System.out.println(strStr(haystack, needle));
  }

  public static int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }


    int n = needle.length();
    for (int i = 0; i < haystack.length()-n; i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        if (haystack.substring(i, i+n).equals(needle)) {
          return i;
        }
      }
    }
    return -1;
  }

}

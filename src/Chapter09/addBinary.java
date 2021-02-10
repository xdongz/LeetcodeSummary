/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

/**
 * No.67 二进制求和
 */
public class addBinary {

  public static void main(String[] args) {
    System.out.println(addBinary("11111", "1011"));
  }

  public static String addBinary(String a, String b) {

    int n1 = a.length(), n2 = b.length();
    //保证a的长度大于b的长度，以免分两种情况讨论
    if (n2 > n1) {
      String temp = a;
      a = b;
      b = temp;
      int t = n1;
      n1 = n2;
      n2 = t;
    }

    StringBuilder str = new StringBuilder();
    //进位
    int addition = 0;

    for (int i = n1 -1, j = n2 - 1; j >= 0; i --, j --) {
      int current = a.charAt(i) - '0' + b.charAt(j) - '0' + addition;
      str = str.insert(0, current % 2);
      addition = current / 2;
    }

    for (int i = n1 - n2 - 1; i >= 0; i --) {
      int current = a.charAt(i) - '0'+ addition;
      str = str.insert(0, current % 2);
      addition = current / 2;
    }

    if (addition > 0) {
      str.insert(0, (char)(addition + '0'));
    }

    return str.toString();
  }

}

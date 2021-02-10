/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

/**
 * No.168
 * 本题和base7差不多，十进制转26进制
 * 注意是从1-26而不是0-25
 */
public class excelSheet {

  public static void main(String[] args) {

    System.out.println(covertToTitle(701));
  }

  public static String covertToTitle(int n) {
    //用StringBuilder比String拼接快很多
    StringBuilder str = new StringBuilder();
    while (n > 0) {
      int a = n / 26, b = n % 26;
      if (b == 0) {
        str.insert(0, 'Z');
        a = a - 1;
      } else {
        str.insert(0, (char) ('A' + (b - 1)));
      }
      n = a;
    }
    return str.toString();
  }

}

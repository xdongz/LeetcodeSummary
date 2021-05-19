/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter12;

/**
 * No.12 整数转罗马数字
 *
 * 最开始想的是用map，但是if else分支太多了，后来看了题解，用两个数组就可以了。
 */
public class IntToRoman {

  public static void main(String[] args) {
    int num = 6;
    System.out.println(intToRoman(num));
  }

  public static String intToRoman(int num) {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder res = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
      int value = values[i];
      while (num >= value) {
        res.append(symbols[i]);
        num = num - value;
      }
      if (num == 0) {
        break;
      }
    }
    return res.toString();
  }


}

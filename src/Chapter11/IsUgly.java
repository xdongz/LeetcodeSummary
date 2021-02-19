/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

/**
 * No.263 丑数
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 */
public class IsUgly {

  public static void main(String[] args) {
    System.out.println(isUgly(8));
  }

  //判断是否只能被2，3，5整除，其中1是丑数 0不是丑数
  public static boolean isUgly(int num) {
    if (num == 1) {
      return true;
    }

    if (num == 0) {
      return false;
    }

    if (num % 2 == 0) {
      return isUgly(num / 2);
    } else if (num % 3 == 0) {
      return isUgly(num / 3);
    } else if (num % 5 == 0) {
      return isUgly(num / 5);
    }
    return false;
  }

}

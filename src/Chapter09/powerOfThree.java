/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

/**
 * 给定一个整数，判断它是否是3的幂次方
 */
public class powerOfThree {

  public static void main(String[] args) {
    System.out.println(isPowerOfThree(-9));
  }

  public static boolean isPowerOfThree(int n) {

    if (n <= 0) {
      return false;
    }

    while (n != 1) {
      int a = n / 3, b = n % 3;
      if (b != 0) {
        return false;
      }
      n = a;
    }
    return true;
  }

}

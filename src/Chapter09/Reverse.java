/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

public class Reverse {

  public static void main(String[] args) {
    System.out.println(reverse(1534236469));
  }

  public static int reverse(int x) {
    int n = Math.abs(x), res = 0;
    while (n != 0) {
      if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
        return 0;
      }
      res = res * 10;
      res += n % 10;
      n = n / 10;
    }
    return x < 0 ? -res : res;
  }

}

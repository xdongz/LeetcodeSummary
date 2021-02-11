/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter10;

/**
 * No.476
 * 给定一个正整数，输出该数的二进制表示取反后的值
 */
public class findComplement {

  public static void main(String[] args) {
    System.out.println(findComplement(1));
  }

  public static int findComplement(int num) {
    int ans = 0;
    int count = 0;
    while (num > 0) {
      int curr = 1 - (num & 1);
      ans += (curr << count);
      num  = num >> 1;
      count ++;
    }
    return ans;

  }

}

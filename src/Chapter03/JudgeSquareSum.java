/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter03;

/**
 * No. 633 平方数之和
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 和两数之和的解法一样
 */
public class JudgeSquareSum {

  public static void main(String[] args) {
    System.out.println(judgeSquareSum(0));
  }

  public static boolean judgeSquareSum(int c) {
    int left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      int sum = left * left + right * right;
      if (sum == c) {
        return true;
      } else if (sum < c) {
        left ++;
      } else {
        right --;
      }
    }
    return false;
  }

}

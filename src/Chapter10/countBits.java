/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter10;

import java.util.Arrays;

/**
 * No.338
 * 给定一个非负整数n，求从0 到n 的所有数字的二进制表达中，分别有多少个1。
 */
public class countBits {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(countBits(2)));
  }

  //方法1： 最容易想到的方法是遍历0-num，分别求每个数中1个个数
  //但是如果是自己写while循环，那么复杂度是O(n*m)
  public static int[] countBits(int num) {
    int[] res = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      //res[i] = Integer.bitCount(i);
      res[i] = getOnes(i);
    }
    return res;
  }

  public static int getOnes(int n) {
    int ans = 0;
    while (n > 0) {
      ans += n & 1;
      n = n >> 1;
    }
    return ans;
  }

  //方法2：动态规划
  //因为0-n这n+1个数不是随机的n+1个数
  //所以我们可以充分利用他们之间的关系和二进制数的特点来求解
  public static int[] countBits2(int num) {
    //dp[i]代表i的二进制表示中1的个数
    int[] dp = new int[num + 1];
    for (int i = 0; i <= num ; i++) {
      //如果i的二进制最后一位是1，那么它的1的个数等于dp[i-1] + 1
      //如果i的二进制最后一位是0，那么它的1的个数等于dp[i>>1]
      if ((i & 1) == 1) {
        dp[i] = dp[i - 1] + 1;
      } else {
        dp[i] = dp[i >> 1];
      }
    }
    return dp;
  }

}

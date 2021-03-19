/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter07;

/**
 * No.650 只有两个键 的键盘
 *
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字n。你需要使用最少的操作次数，在记事本中打印出恰好n个 'A'。输出能够打印出n个 'A' 的最少操作次数。
 *
 */
public class TwoKeysKeyboard {

  public static void main(String[] args) {
    System.out.println(minSteps(9));
  }

  public static int minSteps(int n) {
    int[] dp = new int[n+1];
    int h = (int) Math.sqrt(n);
    dp[1] = 0;
    for (int i = 2; i < n+1; i++) {
      // 最坏的情况是执行i次
      dp[i] = i;
      for (int j = 2; j <= h; j++) {
        if (i % j == 0) {
          // 如果j能被i整除，相当于是先变成j，再把j个A看成一个整体，然后进行复制粘贴的操作，共操作i/j次
          // 所以最后一定会被分解成几个质因数的加法，因此遇到第一个能把i整除的数就可以break了，因为结果都一样
          dp[i] = dp[j] + dp[i/j];
          break;
        }
      }
    }
    return dp[n];
  }

}

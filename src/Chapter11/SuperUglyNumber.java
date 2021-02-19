/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * No.313
 *
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 本题是NthUglyNumber的升级版
 */
public class SuperUglyNumber {

  public static void main(String[] args) {
    int n = 12;
    int[] primes = {2,7,13,19};
    System.out.println(method2(n, primes));
  }

  //方法一：优先队列
  //用这种方法去解313会超时，应该有优化的方法
  public static int nthSuperUglyNumber(int n, int[] primes) {
    Set<Long> set = new HashSet<>();
    PriorityQueue<Long> queue = new PriorityQueue<>();
    int[] ans = new int[n];
    set.add(1L);
    queue.add(1L);

    for (int i = 0; i < n; i++) {
      ans[i] = queue.poll().intValue();
      for (int j : primes) {
        long uglyNum = j * ans[i];
        if (! set.contains(uglyNum)) {
          set.add(uglyNum);
          queue.offer(uglyNum);
        }
      }
    }
    return ans[n-1];
  }

  //方法二：k指针法
  public static int method2(int n, int[] primes) {
    int k = primes.length;
    //存放着每一个质因数对应的指针
    int[] points = new int[k];
    Arrays.fill(points, 0);

    //存放答案
    int[] ans = new int[n];
    ans[0] = 1;

    for (int i = 1; i < n; i++) {
      //存放着每次计算
      int[] uglyValue = new int[k];
      int minValue = Integer.MAX_VALUE;
      for (int j = 0; j < k; j++) {
        uglyValue[j] = primes[j] * ans[points[j]];
        minValue = Math.min(minValue, uglyValue[j]);
      }
      ans[i] = minValue;

      for (int j = 0; j < k; j++) {
        if (uglyValue[j] == minValue) {
          points[j] ++;
        }
      }
    }
    return ans[n-1];
  }

}

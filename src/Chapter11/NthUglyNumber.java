/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * No.264 丑数II
 *
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 本题有两种解法： 优先队列和三指针法
 * 在解题之前首先要明白如何判断一个数是不是丑数
 * 如果一个数是之前所计算的丑数与2，3，5的乘积，那么这个数也是丑数
 *
 */
public class NthUglyNumber {

  public static void main(String[] args) {
    System.out.println(method2(1409));
  }

  /**
   * 方法一：优先队列
   * 创建一个优先队列用来存储每次计算的值，默认的排序方式是从小到大。
   * 优先队列是堆排序，它只会保证第一个元素也就是根节点是当前优先队列中的最小的元素
   * 而且每一次变化之后，比如offer或者poll，都会重新进行堆排序
   *
   * 需要注意的是：优先队列这种方法可能会计算出很多第n个丑数之后的值，这些值有可能会超过integer的最大值
   * 所以需要定义long型的set和queue来保存
   *
   */
  public static int nthUglyNumber(int n) {
    //创建一个set用来去重
    Set<Long> set = new HashSet<>();
    PriorityQueue<Long> queue = new PriorityQueue<>();
    int[] primes = {2, 3, 5};
    //创建一个数组用来存储1..n的结果
    long[] ans = new long[n];
    queue.offer(1L);
    set.add(1L);
    for (int i = 0; i < n; i++) {
      //每次poll出来的值一定是第i个最小的值
      ans[i] = queue.poll();
      //将当前得到的最小的丑数与2，3，5做乘积，并把值都加入到队列中
      for (int j : primes) {
        long num = j * ans[i];
        if (!set.contains(num)) {
          set.add(num);
          queue.offer(num);
        }
      }
    }
    return (int) ans[n - 1];
  }

  /**
   * 方法二：三指针法
   * 每个指针对应着当前数组元素是乘以2还是3还是5
   */
  public static int method2(int n) {
    int[] ans = new int[n];
    ans[0] = 1;
    int[] primes = {2, 3, 5};

    //最开始三个指针都指向数组的第一个值
    int p2 = 0, p3 = 0, p5 = 0;
    for (int i = 1; i < n; i++) {
      int value_2 = primes[0] * ans[p2];
      int value_3 = primes[1] * ans[p3];
      int value_5 = primes[2] * ans[p5];
      //每次循环把乘积中最小的值取出来放入数组中
      int minValue = Math.min(value_2, Math.min(value_3, value_5));
      ans[i] = minValue;

      //计算出来的值等于最小值的指针后移一位
      if (value_2 == minValue) {
        p2 ++;
      }

      if (value_3 == minValue) {
        p3 ++;
      }

      if (value_5 == minValue) {
        p5 ++;
      }
    }
    return ans[n - 1];
  }
}

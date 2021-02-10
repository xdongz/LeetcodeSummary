/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

import java.util.Arrays;

//题目 204
//给定一个数字n， 求小于n的质数的个数
public class countPrimes {

  public static void main(String[] args) {
    System.out.println(method2(10));

  }


  //首先想到的方法是：
  //创建一个数组标记当前的数字是不是质数
  //从1开始遍历到n，假设当前数字是i，那么i的倍数肯定不是质数
  //因为是从小到大遍历，如果i不是质数，那么它肯定是前面某个数的倍数，所以肯定被标记过了
  //最后就是注意边界条件：n <= 2 时，返回值都应为0
  public static int method1(int n) {

    if (n <= 2) {
      return 0;
    }

    boolean[] isPrimes = new boolean[n];
    Arrays.fill(isPrimes, true);
    //除去0和1
    int count = n - 2;

    for (int i = 2; i < n; i++) {
      if (isPrimes[i]) {
        for (int j = 2 * i; j < n; j += i) {
          if (isPrimes[j]) {
            isPrimes[j] = false;
            count--;
          }
        }
      }
    }
    return count;
  }

  //方法1还可以优化
  //偶数肯定不是质数，所以在判断时直接可以略过偶数
  public static int method2(int n) {
    if (n <= 2) {
      return 0;
    }

    boolean[] isPrimes = new boolean[n];
    Arrays.fill(isPrimes, true);
    //除去偶数，那么初始值为n的一半
    int count = n / 2;

    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      for (int j = i * i; j < n; j += 2 * i) {
        if (isPrimes[j]) {
          isPrimes[j] = false;
          count --;
        }
      }
    }
    return count;
  }

}

/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

import java.util.HashSet;
import java.util.Set;

/**
 * No.202
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为1，那么这个数就是快乐数。
 *
 */
public class happyNum_2_10 {

  public static void main(String[] args) {
    System.out.println(isHappy2(2));
  }

  /**
   * 这道题目最关键的点在于，理解它不会值越来越大,无限期地进行下去
   * 比如一个很大的数(由30个9组成)，那么它的下一步也只是81 * 30 = 2430
   * 所以它要么最终会变成1，要么会进入一个循环。
   *
   * 如果我们理清了这一点，就很好做了。
   * 第一种方法，我们用HashSet来存放每一步得到的值
   * 如果值是1，那么return true，如果值在Set中没有，那么就加入进去，如果值在Set中已经存在了，表示进入了循环，返回false
   *
   * @param n 输入的数字n
   * @return 是否是happy数
   */
  public static boolean isHappy1(int n) {
    Set<Integer> set = new HashSet<>();

    while (true) {
      int num = getNext(n);
      if (num != 1 && !set.contains(num)) {
        set.add(num);
        n = num;
      } else if (num == 1) {
        return true;
      } else if (set.contains(num)) {
        return false;
      }
    }
  }

  /**
   * 第二种方法是快慢指针法。环路检测首先要想到的方法就是快慢指针法
   * 如果存在环路，那么快慢指针最终会遇上。
   * 如果能最终到达1，那么快指针一定会先到
   * 最后还要考虑到一开始n就是1的情况
   *
   * @param n 输入的数字n
   * @return 是否为happy数
   */
  public static boolean isHappy2(int n) {
    int slowNode  = n;
    int fastNode = getNext(getNext(n));

    while (slowNode != fastNode) {
      slowNode = getNext(slowNode);
      fastNode = getNext(getNext(fastNode));
      if (fastNode == 1) {
        return true;
      }
    }
    return fastNode == 1;
  }

  public static int getNext(int n) {
    int total = 0;
    while (n > 0) {
      total += (n % 10) * (n % 10);
      n = n / 10;
    }
    return total;
  }

}

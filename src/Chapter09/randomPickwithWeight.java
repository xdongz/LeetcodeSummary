/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * No.584
 * 输入是一维正整数数组，每个位置的值表示该位置的权重，如w = [1,3]
 * 要求按照权重去采样
 * 输出是采样的索引
 */
public class randomPickwithWeight {

  private int[] w;
  private List<Integer> psum = new ArrayList<>();

  public randomPickwithWeight(int[] w) {
    this.w = w;
  }

  /**
   * 计算前缀和，也就是到每个位置为止之前所有数字的和
   * 如w = [1,3],那么psum = [1,4]，那么随机产生一个[0,4)之间的数字，小于1的概率就是1/4，1-4之间的概率就是3/4，满足题意
   *
   * @param psum 前缀和数组
   * @param w 权重数组
   */
  public void calPsum(List psum, int[] w) {
    int total = 0;
    for (int x : w) {
      total += x;
      psum.add(total);
    }
  }

  public int pickIndex() {
    Random rand = new Random();
    calPsum(psum, w);
    int target = rand.nextInt(psum.get(psum.size() - 1));

    //二分法查找随机生成的target在psum中的位置
    int left = 0, right = psum.size() - 1;
    while (left != right) {
      int mid = (left + right) / 2;
      if (psum.get(mid) > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}

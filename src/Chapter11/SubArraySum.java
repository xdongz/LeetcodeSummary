/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.HashMap;
import java.util.Map;

/**
 * No.560 和为k的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 连续的子数组和，所以首先应想到前缀和
 */
public class SubArraySum {

  public static void main(String[] args) {
    int[] nums = {1,1,1};
    int k = 2;
    System.out.println(subarraySum(nums, k));
  }

  /**
   * 方法一虽然用到了前缀和，但是复杂度太高
   *
   */
  public static int subarraySum(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    int[] psum = new int[n];

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        psum[i] = nums[i];
      } else {
        psum[i] = psum[i - 1] + nums[i];
      }
    }

    int ans = psum[0] == k ? 1 : 0;
    for (int i = 1; i < n; i++) {
      if (psum[i] == k) {
        ans ++;
      }
      for (int j = 0; j < i; j++) {
        if (psum[i] - psum[j] == k) {
          ans ++;
        }
      }
    }
    return ans;
  }

  /**
   * 方法二 结合了前缀和和 TwoSum题的优点
   * 利用map存储前缀和和对应的个数
   *
   * 需要注意的一点是： 当psum - k == 0时，结果应该加1
   * 所以map.get(0) 应为1
   *
   */
  public static int method2(int[] nums, int k) {
    int psum = 0, n = nums.length;
    //key是前缀和，value是对应的个数
    Map<Integer, Integer> map = new HashMap<>();

    int ans = 0;
    map.put(0, 1);
    for (int i = 0; i < n; i++) {
      psum += nums[i];
      ans += map.getOrDefault(psum - k, 0);
      map.put(psum, map.getOrDefault(psum, 0) + 1);
    }
    return ans;
  }

}

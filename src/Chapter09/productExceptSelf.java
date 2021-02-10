/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

import java.util.Arrays;

/**
 * No.238 除自身以外的乘积
 */
public class productExceptSelf {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    System.out.println(Arrays.toString(productExceptSelf(nums)));
  }

  /**
   * 这道题不能用除法，所以就增加了难度，而且nums中的元素有可能为0，用除法也行不通
   * 那么我们可以分别计算当前元素左边的乘积和当前元素右边的乘积，再把两者相乘
   * 这道题与第135题有异曲同工之妙，可以结合着看。
   *
   * @param nums
   * @return
   */
  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res, 1);

    int left = 1, right = 1;
    for (int i = 1; i < n; i ++) {
      left = nums[i - 1] * left;
      res[i] = left;
    }

    for (int i = n - 2; i >= 0; i --) {
      right = nums[i + 1] * right;
      res[i] = res[i] * right;
    }

    return res;
  }
}

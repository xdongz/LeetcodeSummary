/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter02;

import java.util.Arrays;

/**
 * No.11 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 */
public class MaxArea {

  public static void main(String[] args) {
    int[] height = {1,1};
    System.out.println(method2(height));
  }

  /**
   * 双指针法。这道题双指针法有点难想到。
   */
  public static int method2(int[] height) {
    int l = 0, r = height.length-1;
    int ans = 0;
    while (l < r) {
      int area = Math.min(height[l], height[r]) * (r - l);
      ans = Math.max(ans, area);
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return ans;
  }

  /**
   * 暴力法
   */
  public static int maxArea(int[] height) {
    int[] dp = new int[height.length];
    Arrays.fill(dp, 0);
    for (int i = 1; i < height.length; i++) {
      for (int j = 0; j < i; j++) {
        if (height[j] >= height[i]) {
          dp[i] = Math.max(dp[i], height[i] * (i-j));
          break;
        }
        dp[i] = Math.max(dp[i], height[j] * (i-j));
      }
    }
    int max = 0;
    for (int j : dp) {
      if (j > max) {
        max = j;
      }
    }
    return max;
  }

}

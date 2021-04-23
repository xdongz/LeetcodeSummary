/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No. 368 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * 遇到这种最长，最大等题目，要首先想要动态规划或者贪心。
 * 此题和最长上升子序列很像，比较难想的是根据最大值和最大长度倒推子序列
 */
public class LargestDivisibleSubSets {

  public static void main(String[] args) {
    int[] nums = {2,3,6,12};
    List<Integer> res;
    res = largestDivisibleSubset(nums);
    System.out.println(res);
  }

  public static List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int maxSize = 1;
    int maxValue = nums[0];
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
      if (dp[i] > maxSize) {
        maxSize = dp[i];
        maxValue = nums[i];
      }
    }


    // 倒推获得最大子集
    List<Integer> res = new ArrayList<>();
    if (maxSize == 1) {
      res.add(nums[0]);
      return res;
    }
    for (int i = nums.length-1; i >= 0 && maxSize > 0; i--) {
      if (dp[i] == maxSize && maxValue % nums[i] == 0) {
        res.add(nums[i]);
        maxValue = nums[i];
        maxSize--;
      }
    }
    return res;
  }

}

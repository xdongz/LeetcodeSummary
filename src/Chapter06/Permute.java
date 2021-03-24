/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * No.46 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 回溯算法有一个层的概念，第二就是递归后要恢复本层的状态
 */
public class Permute {

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    permute(nums);
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> every = new ArrayList<>();
    if (nums.length == 0) {
      return res;
    }
    for (int num : nums) {
      every.add(num);
    }
    backtracking(every, res, 0);
    return res;

  }

  public static void backtracking(List<Integer> nums, List<List<Integer>> res, int level) {
    if (level == nums.size()) {
      // 注意：这里不能直接加nums
      res.add(new ArrayList<>(nums));
      return;
    }

    for (int i = level; i < nums.size(); i++) {
      // 本层要做的事： 其后所有元素都可与nums[level]交换
      Collections.swap(nums, i, level);
      backtracking(nums, res, level + 1);
      // 恢复本层的状态
      Collections.swap(nums, i, level);
    }
  }

}

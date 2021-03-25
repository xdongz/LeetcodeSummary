/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter06;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.77 组合
 *
 * 给定一个整数n 和一个整数k，求在1 到n 中选取k 个数字的所有组合方法
 *
 * 类似于排列问题，我们也可以进行回溯。排列回溯的是交换的位置，而组合回溯的是否把当
 * 前的数字加入结果中。
 */
public class Combination {

  public static void main(String[] args) {
    List<List<Integer>> ans = combine(2, 2);
    for (List<Integer> a : ans) {
      System.out.println(a);
    }
  }

  public static List<List<Integer>> combine(int n, int k) {
    List<Integer> nums = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }

    List<List<Integer>> res = new ArrayList<>();
    // 注意这里要选择栈，因为每次移除的是最新加进去的数
    Deque<Integer> path = new LinkedList<>();
    backtracking(res, path, nums, k, 0, -1);
    return res;
  }

  public static void backtracking(List<List<Integer>> res, Deque<Integer> path, List<Integer> nums, int k, int level, int index) {
    if (level == k) {
      res.add(new ArrayList<>(path));
      return;
    }

    // 在i之后选一个数加入到path中
    for (int i = index+1; i < nums.size(); i++) {
      path.push(nums.get(i));
      backtracking(res, path, nums, k, level + 1, i);
      path.pop();
    }
  }

}

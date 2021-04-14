/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */package Chapter11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.456 132模式
 *
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列ai, aj, ak被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 */
public class Find132Pattern {

  public static void main(String[] args) {
    int[] nums = {3,1,4,2};
    System.out.println(find132pattern(nums));
  }

  public static boolean find132pattern(int[] nums) {
    int n = nums.length;
    // min数组中存放着从0-当前位置的最小值
    int[] min = new int[n];
    min[0] = nums[0];
    for (int i = 1; i < n; i++) {
      min[i] = Math.min(min[i-1], nums[i]);
    }

    Deque<Integer> stack = new LinkedList<>();
    stack.push(nums[n-1]);
    // 从后向前遍历，因为k比j大，栈中的元素的索引应大于j
    for (int j = n-2; j > 0 ; j--) {
      // min[j]代表ai，nums[j]代表aj
      if (nums[j] > min[j]) {
        while (!stack.isEmpty() && stack.peek() <= min[j]) {
          // 这种情况栈顶元素肯定不是ak
          stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() < nums[j]) {
          return true;
        }
        // num[j] == min[j]的情况不需要被压入栈中了，因为肯定会被弹出
        stack.push(nums[j]);
      }
    }
    return false;
  }

}

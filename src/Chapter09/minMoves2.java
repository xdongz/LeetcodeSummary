/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

import java.util.Arrays;

/**
 * No.426 最少移动次数使数组元素相等。
 * 这道题其实是考察某个数x使得|x-a1| + |x-a2| + |x-a3| + ...之和最小
 * 首先我们需要回忆起初中学的一个公式 |a| + |b| >= |a + b| (ab >= 0)  |a| + |b| >= |a - b| (ab <= 0)
 * 那么|x-a1| + |x-a2| >= |a1 - a2|, 当a1 <= x <= a2时等式成立
 * 所以这道题的解题思路就是先将nums排序，然后得出中间位置的那个数，即中位数，就是x。
 */
public class minMoves2 {

  public static void main(String[] args) {
    int[] nums = {1,1,2,3};
    System.out.println(minMoves2(nums));
  }

  public static int minMoves2(int[] nums) {
    Arrays.sort(nums);

    int n = nums.length;
    int num = nums[n / 2];
    int count = 0;

    for (int j : nums) {
      count += Math.abs(num - j);
    }
    return count;
  }
}

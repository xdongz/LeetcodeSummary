/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1 Two Sum
 * 给定一个整数数组，已知有且只有两个数的和等于给定值，求这两个数的位置。
 *
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map= new HashMap<>();

    //虽然如果有重复的数字，后面的索引会覆盖前面的索引，
    //但是由于第二次循环是从前往后遍历，所以不要紧
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
        return new int[] {i, map.get(target - nums[i])};
      }
    }
    return null;
  }

}

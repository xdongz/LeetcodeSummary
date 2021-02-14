/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.ArrayList;
import java.util.List;

/**
 * No. 448
 * 给定一个长度为n 的数组，其中包含范围为1 到n 的整数，有些整数重复了多次，有些整数
 * 没有出现，求1 到n 中没有出现过的整数。
 *
 * 最先想到的是创建一个数组标记哪些位置上的数出现了，但是如果要不创建额外空间的情况下呢？
 * 其实主要就是为了标记，那么也可以在原数组上标记，因为原数组的所有数都是正数，那么标记可以把原来的数改为负数
 */
public class findDisappearedNumber {

  public List<Integer> findDisapperedNumber(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int pos = Math.abs(nums[i]) - 1;
      if (nums[pos] > 0) {
        nums[pos] = -nums[pos];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        ans.add(i + 1);
      }
    }
    return ans;
  }

}

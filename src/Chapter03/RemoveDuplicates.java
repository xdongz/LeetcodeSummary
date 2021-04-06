/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter03;

/**
 * No. 80 删除有序数组中的重复项||
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 这道题十分巧妙，其实需要把后面不重复的元素移到前面即可，不需要把重复的元素移动到后面
 */
public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] nums = {0,0,1,1,1,1,2,3,3};
    int len = removeDuplicates(nums);
    System.out.println(len);
    for (int i = 0; i < len; i++) {
      System.out.println(nums[i]);
    }
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    // 0-(p1-1)代表已处理好的索引，p2代表当前正要处理的元素索引
    int p1 = 2, p2 = 2;
    while (p2 < nums.length) {
      // 需不需要删掉，就要看当前元素是否与已处理好的倒数第二个索引的值是否相等
      if (nums[p2] != nums[p1-2]) {
        // 如果不相等，那么这个值是需要被保留的，所以直接赋值给p1，那么p1处的值就完成了处理
        nums[p1] = nums[p2];
        p1++;
      }
      // 如果相等，那么这个值需要被删掉，所以不用管，直接向后移动一次p2
      p2++;
    }
    return p1;
  }

}

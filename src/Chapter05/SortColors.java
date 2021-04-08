/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter05;

import java.util.Arrays;

/**
 * No.75 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 不能用排序，且使用常数空间一趟扫描
 * 解题思路：双指针法， p0交换0， p2交换2
 *
 */
public class SortColors {

  public static void main(String[] args) {
    int[] nums = {2,1,2};
    sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }

  // 把0挪到前面，2挪到后面
  public static void sortColors(int[] nums) {
    int p0 = 0, p2 = nums.length - 1;

    // p2要在p0前面判断，因为有可能i和p2交换后nums[i] 是0 了，此时应再与p0交换
    for (int i = 0; i <= p2; i++) {

      while (p2 >= i && nums[i] == 2) {
        // 这段交换要放到while循环里，且放到p2--之前，因为如果放到p2--之后，有可能p2自减之后小于i了
        // 而如果不放在while循环里，有可能p2位置是2，交换了之后nums[i]还是2，而下一次i就加1了
        nums[i] = nums[p2];
        nums[p2] = 2;
        p2--;
      }


      if (nums[i] == 0) {
        nums[i] = nums[p0];
        nums[p0] = 0;
        // 此时应该用p0++而不是直接p0=i，因为p0-i之间可能还有值为1的元素
        p0 ++;
      }
    }
  }

}

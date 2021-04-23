/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter03;

public class RemoveElement {

  public static void main(String[] args) {
    int[] nums = {0,1,2,2,3,0,4,2};
    int len = removeElement(nums, 2);
    for (int i = 0; i < len; i++) {
      System.out.println(nums[i]);
    }
  }

  public static int removeElement(int[] nums, int val) {
    int p1 = 0;
    for (int p2 = 0; p2 < nums.length; p2++) {
     if (nums[p2] != val) {
       nums[p1] = nums[p2];
       p1++;
     }
    }

    return p1;
  }

}

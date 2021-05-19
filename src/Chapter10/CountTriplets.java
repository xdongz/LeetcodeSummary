/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter10;

/**
 * No.1442 形成两个异或相等数组的三元组数目
 *
 * 解题思路：遇到这种连续索引异或的情况，首先想到前缀和
 */
public class CountTriplets {

  public static void main(String[] args) {
    int[] arr = {2,3};
    System.out.println(countTriplets(arr));
  }
  public static int countTriplets(int[] arr) {
    int n = arr.length;
    int[] preSum = new int[n];
    preSum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      preSum[i] = preSum[i-1] ^ arr[i];
    }

    int count = 0;
    for (int i = 0; i < n-1; i++) {
      int start = i == 0 ? 0 : arr[i-1];
      for (int j = i+1; j < n; j++) {
        preSum[j] = preSum[j] ^ start;
        if (preSum[j] == 0) {
          count += j - i;
        }
      }
    }
    return count;
  }

}

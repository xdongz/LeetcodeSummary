/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter10;

import java.util.Arrays;

/**
 * No.1310 子数组异或查询
 *
 * 有一个正整数数组arr，现给你一个对应的查询数组queries，其中queries[i] = [Li,Ri]。
 * 对于每个查询i，请你计算从Li到Ri的XOR值（即arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * 并返回一个包含给定查询queries所有结果的数组。
 *
 * 朴素的前缀和方法哈哈哈。
 */
public class XorQueries {

  public static void main(String[] args) {
    int[] arr = {1,3,4,8};
    int[][] queries = {{0,1}, {1,2}, {0,3}, {3,3}};
    System.out.println(Arrays.toString(xorQueries(arr, queries)));
  }

  public static int[] xorQueries(int[] arr, int[][] queries) {
    int[] temp = new int[arr.length];
    int[] res = new int[queries.length];
    temp[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      temp[i] = temp[i-1] ^ arr[i];
    }
    for (int i = 0; i < queries.length; i++) {
      int left = queries[i][0], right = queries[i][1];
      if (left > 0) {
        res[i] = temp[right] ^ temp[left - 1];
      } else {
        res[i] = temp[right];
      }
    }
    return res;
  }

}

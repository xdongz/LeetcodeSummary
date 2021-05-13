/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter10;

import java.util.Arrays;

/**
 * No.1734. 解码异或后的排列
 *
 * 给你一个整数数组perm，它是前n个正整数的排列，且n是个 奇数。
 * 它被加密成另一个长度为 n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。比方说，如果perm = [1,3,2]，那么encoded = [2,1]。
 * 给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。
 *
 * 对比1720,最关键在于求出perm[0]，而perm[0]可以通过它是前 n 个正整数的排列，且 n 是个 奇数 这两个信息来求出。
 */
public class DecodeII {

  public static void main(String[] args) {
    int[] encoded = {6,5,4,6};
    System.out.println(Arrays.toString(decode(encoded)));
  }


  public static int[] decode(int[] encoded) {
    int n = encoded.length, total = 0, odd = 0;
    int[] perm = new int[n+1];
    for (int i = 1; i <= n+1; i++) {
      total ^= i;
    }

    for (int i = 1; i < n; i = i+2) {
      odd ^= encoded[i];
    }

    perm[0] = total ^ odd;

    for (int i = 1; i < n+1; i++) {
      perm[i] = perm[i-1] ^ encoded[i-1];
    }
    return perm;
  }

}

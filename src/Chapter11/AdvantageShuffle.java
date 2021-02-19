/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * No.870 优势洗牌
 *
 * 给定两个大小相等的数组A和B，A 相对于 B 的优势可以用满足A[i] > B[i]的索引 i的数目来描述。
 * 返回A的任意排列，使其相对于 B的优势最大化。
 *
 * 本题解题思路：如果A中最小的数a大于B中最小的数b，那么他们一定要配对在一起，再比较A中第二小的数和B中第二小的数
 * 如果A中最小的数小于B中最小的数，那么A中最小的数将无法得分。再比较A中第二小的数和B中最小的数...
 *
 *
 */
public class AdvantageShuffle {

  public static void main(String[] args) {
    int[] A= {12,24,8,32};
    int[] B = {13,25,32,11};
    System.out.println(Arrays.toString(advantageCount(A, B)));
  }
  public static int[] advantageCount(int[] A, int[] B) {
    int[] tempA = A.clone();
    int[] tempB = B.clone();

    //key是B中的元素，value是可与之配对的元素，由于可以有重复的值，所以value是deque
    Map<Integer, Deque<Integer>> pair = new HashMap<>();
    //保存着A中无法得分的元素
    Deque<Integer> remaining = new LinkedList<>();
    for (int b: tempB) {
      pair.put(b, new LinkedList<>());
    }

    Arrays.sort(tempA);
    Arrays.sort(tempB);

    int j = 0;
    for (int a : tempA) {
      if (a > tempB[j]) {
        pair.get(tempB[j++]).add(a);
      } else {
        remaining.add(a);
      }
    }

    int[] ans = new int[B.length];
    for (int i = 0; i < B.length; i++) {
      if (pair.get(B[i]).size() != 0) {
        ans[i] = pair.get(B[i]).poll();
      } else {
        //A中无法得分的元素可以与B中没有配对的元素任意搭配，因为这些B中的元素都比A中无法得分的元素大
        ans[i] = remaining.poll();
      }
    }
    return ans;
  }

}

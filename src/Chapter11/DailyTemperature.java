/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * No.793
 * 给定每天的温度，求对于每一天需要等几天才可以等到更暖和的一天。如果该天之后不存在
 * 更暖和的天气，则记为0。
 *
 * 维护一个单调递减的栈，栈中的元素表示第几天
 * 遍历数组，当栈为空时把当前索引i放入栈中
 * 当栈不为空时，比较当前索引i对应的温度与栈顶元素p对应的温度，如果比栈顶元素的大，那么弹出栈，
 * 并更新ans[p] = i - p; 理由是对于p来说，i是它遇到的第一个小于它的元素
 */
public class DailyTemperature {

  public static void main(String[] args) {
    int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
    System.out.println(Arrays.toString(dailyTemperatures(T)));
  }

  public static int[] dailyTemperatures(int[] T) {
    int n = T.length;
    int[] ans = new int[n];
    Deque<Integer> stack = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        int id = stack.pop();
        ans[id] = i - id;
      }
      stack.push(i);
    }
    return ans;
  }

}

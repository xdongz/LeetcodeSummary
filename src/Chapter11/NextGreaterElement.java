/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * No.503 下一个更大的元素II
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 */
public class NextGreaterElement {

  public static void main(String[] args) {
    int[] nums = {1,2,6,5,6,5,2,1};
    System.out.println(Arrays.toString(nextGreaterElement(nums)));
  }

  /**
   * DailyTemperature的变种题，所以也是用单调栈来解决此题
   * 该题比较难的点在于是循环数组，所以需要思考合适结束循环
   * 其实在第二次遍历的时候，如果遇到了该数组的最大值，就可以结束循环了
   *
   * 除了像本题中用一个bool变量表示第二次遍历之外，还可以创建一个长度为原来2倍的数组，然后把原先的值复制一份，这样代码写起来更容易
   *
   */
  public static int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    //判断是否为第二次遍历
    boolean flag = false;

    Deque<Integer> stack = new LinkedList<>();
    int max = -1;

    for (int i = 0; i < n; i++) {

      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        int top = stack.pop();
        if (ans[top] == -1) {
          ans[top] = nums[i];
        }
      }
      if (flag  && nums[i] == max) {
        return ans;
      }
      stack.push(i);
      if (i == n - 1) {
        //第一次遍历后在栈末尾的肯定是最大值
        max = nums[stack.peekLast()];
        i = -1;
        flag = true;
      }
    }
    return ans;
  }

}

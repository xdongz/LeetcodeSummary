
package Chapter11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.42 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 这道题和DailyTemperature一样，都是构造一个单调递减栈
 * 比较巧妙的是如何计算雨水的容量。
 */
public class Trap {

  public int trap(int[] height) {
    int ans = 0, n = height.length;
    Deque<Integer> stack = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        //当前元素与栈顶元素之间的距离
        int dist = i - stack.peek() - 1;
        //界定高度
        int hei = Math.min(height[i], height[stack.peek()]) - height[top];
        ans += dist * hei;
      }
      stack.push(i);

    }
    return ans;
  }

}

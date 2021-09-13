
package Chapter11;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * No.239 滑动窗口的最大值
 *
 * 给定一个整数数组和一个滑动窗口大小，求在这个窗口的滑动过程中，每个时刻其包含的最大值。
 * 
 */
public class MaxSlidingWindow {

  public static void main(String[] args) {
    int[] nums = {7,2,4};
    System.out.println(Arrays.toString(method2(nums, 2)));
  }

  /**
   * 第一种方法： 优先队列
   * 优先队列中每个元素是一个数组
   */
  public static int[] maxSlidingWindow(int[] nums, int k) {
    //int[]中第一个元素代表id，第二个元素代表对应的数组中的值
    //如果值相等，那么id按照从大到小排，如果值不等，按值的从大到小排
    //也就是说队列的第一个元素永远是最大值
    PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) ->
        x[1] == y[1] ? y[0] - x[0] : y[1] - x[1]);
    int n = nums.length;
    int[] ans = new int[n - k + 1];

    //先把前k个元素放入队列中
    for (int i = 0; i < k; i++) {
      queue.offer(new int[] {i, nums[i]});
    }
    ans[0] = queue.peek()[1];

    for (int i = k; i < n; i++) {
      queue.offer(new int[] {i, nums[i]});
      //把队列前端不在滑动窗口中的元素永久删除
      while (queue.peek()[0] < i - k + 1) {
        queue.poll();
      }
      ans[i - k + 1] = queue.peek()[1];
    }
    return ans;
  }

  //方法二： 双向队列
  //其实原理和单调栈差不多，维护一个单调递减的队列
  //但是要把队首中不在滑动窗口的元素永久删除
  public static int[] method2(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int n = nums.length;
    int[] ans = new int[n - k + 1];

    for (int i = 0; i < n; i++) {

      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      int left = i < k ? 0 : i - k + 1;
      while (!deque.isEmpty() && deque.peekFirst() < left) {
        deque.pollFirst();
      }
      ans[left] = nums[deque.peekFirst()];

    }
    return ans;
  }

}

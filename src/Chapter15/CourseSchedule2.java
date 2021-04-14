
package Chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.210 课程表II
 *
 * 给定N 个课程和这些课程的前置必修课，求可以一次性上完所有课的顺序。
 *
 * 输入是一个正整数，表示课程数量，和一个二维矩阵，表示所有的有向边（如[1,0] 表示上课程1 之前必须先上课程0）。
 * 输出是一个一维数组，表示拓扑排序结果。
 *
 * 广度优先遍历可解决此题
 */
public class CourseSchedule2 {

  public static void main(String[] args) {
    int numCourses = 4;
    int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
    System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
  }

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    // 表示每门课程的度，也就是说修该门课程的时候，前面有几门需要修的
    int[] degree = new int[numCourses];
    // 保存每门课程以及它的后续课程
    List<List<Integer>> order = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    int[] ans = new int[numCourses];
    int index = 0;
    Arrays.fill(degree, 0);

    for (int i = 0; i < numCourses; i++) {
      order.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      order.get(pre[1]).add(pre[0]);
      degree[pre[0]] ++;
    }

    for (int i = 0; i < numCourses; i++) {
      // 把无需前置课程的课程加入队列
      if (degree[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int node = queue.poll();
      ans[index ++] = node;
      // 把队首元素弹出后，那么就相当于这门课已修，则这门课的后续课程的度会减1
      for (int i : order.get(node)) {
        degree[i] --;
        // 如果度为0了，那么可以再把元素加入队列中。
        // 所以队列中的元素永远都是度为0的元素
        if (degree[i] == 0) {
          queue.offer(i);
        }
      }
    }
    return index == numCourses ? ans : new int[0];

  }

}

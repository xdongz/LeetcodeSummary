
package Chapter15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.207 课程表
 *
 * 和210题解题思路一样
 */
public class CanFinish {

  public static void main(String[] args) {
    int[][] prerequisites = {{1,0}, {0,2}, {2,3}};
    int numCourses = 4;
    System.out.println(canFinish(numCourses, prerequisites));

  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    // 1. 把所有课程和对应的前置节点存成数组+链表的形式。
    List<List<Integer>> courses = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      courses.add(new ArrayList<>());
    }

    // 2. 存储每个课程的前置课程个数
    int[] preNums = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      int post = prerequisite[0];
      int curr = prerequisite[1];
      // 3. 存储某个课程的后续节点
      // 存储后续节点比前置节点复杂度要低。
      courses.get(curr).add(post);
      preNums[post] ++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (preNums[i] == 0) {
        queue.offer(i);
      }
    }

    int total = 0;
    while (!queue.isEmpty()) {
      total++;
      // 4. 当前课程被修完，那么后续节点的前置课程减1
      int curr = queue.poll();
      for(int c : courses.get(curr)) {
        preNums[c]--;
        if (preNums[c] == 0) {
          queue.offer(c);
        }
      }
    }
    return total == numCourses;

  }

}

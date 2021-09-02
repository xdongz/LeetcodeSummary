
package Chapter15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodes {

  public static void main(String[] args) {
    int[][] graph = {{1,2}, {2,3}, {5}, {0}, {5}, {}, {}};
    System.out.println(eventualSafeNodes(graph));
  }

  public static List<Integer> eventualSafeNodes(int[][] graph) {

    int n = graph.length;
    List<List<Integer>> rg = new ArrayList<>();
    int[] degree = new int[n];
    Arrays.fill(degree, 0);
    for (int i = 0; i < n; i++) {
      rg.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      for (int j : graph[i]) {
        // 1.将所有节点和对应的上游节点加入链表
        rg.get(j).add(i);
        // 2.用数组度表示该节点的出节点个数
        degree[i]++;
      }
    }

    // 3.将度为0的节点加入队列中
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (degree[i] == 0) {
        queue.offer(i);
      }
    }
    List<Integer> ans = new ArrayList<>();
    // 4.每次弹出一个度为0的节点，并将该节点的上游节点的度减一
    while (queue.size() != 0) {
     int value = queue.poll();
     ans.add(value);
      for (Integer index : rg.get(value)) {
        if (--degree[index] == 0) {
          queue.offer(index);
        }
      }
    }
    Collections.sort(ans);
    return ans;
  }
}

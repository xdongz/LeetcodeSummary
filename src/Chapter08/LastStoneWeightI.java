package Chapter08;

import java.util.PriorityQueue;

/**
 * No.1046 最后一块石头的重量
 *
 * 每次取最重的两块石头一起粉碎
 */
public class LastStoneWeightI {

  public static int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 -o1);
    for (int stone : stones) {
      priorityQueue.offer(stone);
    }
    while (priorityQueue.size() >= 2) {
      int a = priorityQueue.poll();
      int b = priorityQueue.poll();
      if (a != b) {
        priorityQueue.offer(Math.abs(a - b));
      }
    }

    return priorityQueue.size() != 0 ? priorityQueue.poll() : 0;

  }

}

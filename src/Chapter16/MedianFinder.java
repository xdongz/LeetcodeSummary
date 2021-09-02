
package Chapter16;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * No.
 *
 * 用大小堆来维护中位数
 */
public class MedianFinder {

  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;

  public MedianFinder() {

    maxHeap = new PriorityQueue<>();
    minHeap = new PriorityQueue<>((o1, o2) -> o2-o1);

  }

  public void addNum(int num) {
    if (minHeap.isEmpty() || num <= minHeap.peek()) {
      minHeap.offer(num);
      if (maxHeap.size() + 1 < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
    } else {
      maxHeap.offer(num);
      if (minHeap.size() < maxHeap.size()) {
        minHeap.offer(maxHeap.poll());
      }
    }
  }

  public double findMedian() {
    if (minHeap.size() == maxHeap.size()) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return minHeap.peek();
    }

  }

}

/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * No.215 数组中的第k个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 解题思路: 第k个最大的元素，那么它的索引一定是在n-k处，用快速排序每次遍历都可以确定pivot的位置，如果pivot的位置刚好是n-k，那么就返回对应的值
 * 如果pivot位置在n-k之前，那么就只用分解pivot之后的组，否则就分解pivot之前的组，不用全部排序
 *
 * 或者用优先队列，把数据一个一个地加进去，然后一个一个第弹出，弹到第k个元素即为所求
 */
public class FindKthLargest {

  public static void main(String[] args) {
    int[] nums = {3,2,3,1,2,4,5,5,6};
    //int[] nums = {1};
    int k = 4;
    System.out.println(heapSort(nums, k));
  }
  // 找第k大的元素，那么排序后它的索引就在n-k上
  public static int findKthLargest(int[] nums, int k) {
    int n = nums.length, id = n - k;
    int lo = 0, hi = n -1;

    while (lo < hi) {
      int partition = partition(nums, lo, hi);
      if (partition == id) {
        return nums[partition];
      } else if (partition < id) {
        lo = partition + 1;
      } else {
        hi = partition - 1;
      }
    }
    return nums[lo];
  }


  public static int partition(int[] nums, int lo, int hi) {
    int pivot = nums[lo];
    int l = lo , r = hi + 1;
    while (l < r) {
      while (l < r &&nums[--r] > pivot) {
        continue;
      }
      while (l < r && nums[++l] < pivot) {
        continue;
      }
      swap(nums, l, r);
    }
    swap(nums, lo, l);
    return l;
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  /**
   * 优先队列实现
   */
  public static int priorityQueue(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    for (int num : nums) {
      priorityQueue.offer(num);
    }

    int num = 0;
    for (int i = 0; i < k; i++) {
      num = priorityQueue.poll();
    }
    return num;
  }

  /**
   * 自己实现堆排序
   */
  public static int heapSort(int[] nums, int k) {
    int[] heap = new int[nums.length+1];
    createHeap(nums, heap);
    int N = heap.length-1;
    // 删除堆的元素
    for (int i = 0; i < k-1; i++) {
      // 交换索引最大的元素与1索引处的元素
      swap(heap, 1, N);
      // 最大索引处的元素不参与下沉
      N--;
      sink(heap, 1, N);
    }
    return heap[1];
  }

  private static void createHeap(int[] nums, int[] heap) {
    System.arraycopy(nums, 0, heap, 1, nums.length);

    for (int i = heap.length/2; i >= 1 ; i--) {
      sink(heap, i, heap.length-1);
    }

  }

  // 在0-range范围内对索引i处的元素进行下沉
  private static void sink(int[] heap, int i, int range) {
    while (2*i <= range) {
      int max = 2*i;
      if (2*i+1 <= range) {
        if (heap[2*i+1] > heap[2*i]) {
          max = 2*i+1;
        }
      }

      if (heap[i] < heap[max]) {
        swap(heap, i, max);
      }
      i = max;
    }
  }

}

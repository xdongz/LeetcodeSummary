/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * No.451 根据字符出现频率排序
 *
 * 给定一个字符串，按照出现的频率降序排列。
 */
public class FrequencySort {

  public static void main(String[] args) {
    String s = "Aabb";
    System.out.println(priorityQueue(s));
  }

  // 方法一：和第347题一样的解法
  public static String frequencySort(String s) {

    int maxCount = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      maxCount = Math.max(maxCount, map.get(ch));
    }

    List<List<Character>> bucket = new ArrayList<>();
    for (int i = 0; i <= maxCount; i++) {
      bucket.add(new ArrayList<>());
    }

    for (char key : map.keySet()) {
      int value = map.get(key);
      bucket.get(value).add(key);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = maxCount; i > 0 ; i--) {
      List<Character> temp = bucket.get(i);
      for (Character ch : temp) {
        int frequency = map.get(ch);
        while (frequency > 0) {
          sb.append(ch);
          frequency--;
        }
      }
    }
    return sb.toString();

  }

  // 方法二：用优先队列
  public static String priorityQueue(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    // 把元素按频次从大到小排列
    PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
      @Override
      public int compare(Character o1, Character o2) {
        return map.get(o2) - map.get(o1);
      }
    });

    for (Character key : map.keySet()) {
      priorityQueue.offer(key);
    }

    StringBuilder sb = new StringBuilder();
    while (!priorityQueue.isEmpty()) {
      char ch = priorityQueue.poll();
      int frequency = map.get(ch);
      while (frequency > 0) {
        sb.append(ch);
        frequency--;
      }
    }
    return sb.toString();
  }

}

package Chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * No.752 打开转盘锁
 *
 * 题解：这道题最朴素的做法就是广度优先遍历
 * 假设当前的数字是curr，枚举curr通过一次旋转得到的数字，
 * 如果该数字没有被使用过且不在deadends里，那么就可以加入队列，用来下一次搜索
 * 如果该数字等于target便返回step
 */
public class OpenLock {

  public static void main(String[] args) {
    String[] deadends = {"0201","0101","0102","1212","2002"};
    String target = "0202";
    System.out.println(openLock(deadends, target));
  }

  public static int openLock(String[] deadends, String target) {
    if (target.equals("0000")) {
      return 0;
    }

    Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

    if (deadSet.contains("0000")) {
      return -1;
    }

    // 这个在BFS和DFS中很重要，避免重复搜索。
    Set<String> used = new HashSet<>();

    Queue<String> queue = new LinkedList<>();
    queue.offer("0000");
    used.add("0000");
    int step = 0;

    while (!queue.isEmpty()) {
      step++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        for (String s : getNext(curr)) {
          if (!used.contains(s) && !deadSet.contains(s)) {
            if (s.equals(target)) {
              return step;
            }

            used.add(s);
            queue.add(s);
          }
        }
      }
    }
    return -1;
  }

  public static List<String> getNext(String curr) {
    List<String> res = new ArrayList<>();
    char[] chars = curr.toCharArray();
    for (int i = 0; i < 4; i++) {
      char num = chars[i];
      chars[i] = numPrev(num);
      res.add(new String(chars));
      chars[i] = numNext(num);
      res.add(new String(chars));
      chars[i] = num;
    }
    return res;
  }

  public static char numPrev(char num) {
    return num == '0' ? '9' : (char) (num - 1);
  }

  public static char numNext(char num) {
    return num == '9' ? '0' : (char) (num + 1);
  }
}

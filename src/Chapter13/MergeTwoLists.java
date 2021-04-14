
package Chapter13;

import java.util.PriorityQueue;

/**
 * No. 21 合并两个有序链表
 */
public class MergeTwoLists {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
    ListNode ans = method3(l1, l2);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }

  // 方法一：同11章中的MergeKList，用优先队列解决
  public static ListNode mergetTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
    queue.offer(l1);
    queue.offer(l2);
    ListNode ans = queue.poll();
    ListNode curr = ans;
    while (!queue.isEmpty()) {
      if (curr.next != null) {
        queue.offer(curr.next);
      }
      curr.next = queue.poll();
      curr = curr.next;
    }
    return ans;
  }

  public static ListNode method2(ListNode l1, ListNode l2) {

    ListNode ans = new ListNode(0);
    ListNode curr = ans;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    curr.next = l1 == null ? l2 : l1;
    return ans.next;
  }

  // 递归
  public static ListNode method3(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    if (l1.val > l2.val) {
      l2.next = method3(l1, l2.next);
      return l2;
    } else {
      l1.next = method3(l1.next, l2);
      return l1;
    }
  }

}

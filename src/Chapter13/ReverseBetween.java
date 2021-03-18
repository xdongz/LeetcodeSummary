/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter13;

/**
 * No.92 反转链表II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 1 <= m <= n <= 链表长度
 */
public class ReverseBetween {

  public static void main(String[] args) {
    //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode head = new ListNode(1, new ListNode(2));
    ListNode ans = reverseBetween(head, 1, 2);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n) {
      return head;
    }

    ListNode dummyHead = new ListNode(0), prev = dummyHead, curr = head, tail = head, next, start;
    dummyHead.next = head;

    for (int i = 0; i < m - 1; i++) {
      prev = prev.next;
      curr = curr.next;
      tail = tail.next;
    }

    start = curr;
    tail = tail.next;
    int j = n - m;
    while (tail != null && j > 0) {
      next = tail.next;
      tail.next = curr;
      curr = tail;
      tail = next;
      j--;
    }

    start.next = tail;
    prev.next = curr;

    return dummyHead.next;
  }

}

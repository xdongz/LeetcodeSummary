/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter13;

/**
 * No. 24 两两交换其中相邻的点
 *
 * 方法二中加了一个dummyHead就好做很多
 */
public class SwapNodesinPairs {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
    ListNode ans = swapPairs(head);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }
  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode curr = head.next;
    ListNode ans = curr;
    ListNode next, prev = head;

    while (true) {
      next = curr.next;
      curr.next = prev;
      prev.next = next;
      if (next != null && next.next != null) {
        curr = next.next;
        prev.next = curr;
        prev = next;
      } else {
        break;
      }
    }
    return ans;
  }

  public static ListNode method2(ListNode head) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode temp = dummyHead;
    while (temp.next != null && temp.next.next != null) {
      ListNode node1 = temp.next;
      ListNode node2 = temp.next.next;
      temp.next = node2;
      node1.next = node2.next;
      node2.next = node1;
      temp = node1;
    }
    return dummyHead.next;
  }

}

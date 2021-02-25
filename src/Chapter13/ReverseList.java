/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter13;

/**
 * No. 206 反转链表
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 翻转链表很基础，这两种方法都需掌握！！！
 */
public class ReverseList {

  public static void main(String[] args) {
    ListNode head = new ListNode( 1, new ListNode(2, new ListNode(3,  null)));
    ListNode ans = reverseList2(head);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }

  // 方法一：非递归
  public ListNode reverseList(ListNode head) {
    ListNode prev = null, next = head;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  // 方法二： 递归
  public static ListNode reverseList2(ListNode head) {
    return method2(head, null);
  }
  public static ListNode method2(ListNode head, ListNode prev) {
    if (head == null) {
      return prev;
    }
    ListNode next = head.next;
    head.next = prev;
    return method2(next, head);
  }
}

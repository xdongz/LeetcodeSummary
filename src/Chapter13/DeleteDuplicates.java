/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter13;

public class DeleteDuplicates {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null))))));
    ListNode ans = deleteDuplicates(head);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode prev = head, curr = head.next;
    while (curr != null) {
      if (curr.val == prev.val) {
        prev.next = curr.next;

      } else {
        prev = prev.next;
      }
      curr = curr.next;
    }
    return head;
  }

}

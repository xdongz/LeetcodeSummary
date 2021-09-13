
package Chapter13;

public class DeleteDuplicatesII {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
//    ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
    ListNode res = deleteDuplicates(head);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode prev = dummyHead, curr = head;
    while (curr != null && curr.next != null) {
      ListNode next = curr.next;

      if (curr.val == next.val) {
        while (next != null && curr.val == next.val) {
          curr = next;
          next = curr.next;
        }
        prev.next = next;
      } else {
        prev = curr;
      }
      curr = next;

    }
    return dummyHead.next;
  }

}

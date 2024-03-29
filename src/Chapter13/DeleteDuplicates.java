
package Chapter13;

/**
 * No.83 删除排序链表中的重复元素
 *
 * 因为链表是排好序的，所以只需要跟前一个链表的值比较，如果相等就删除，否则就往后移
 */
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

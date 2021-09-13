
package Chapter13;

/**
 * No.19 删除链表的倒数第N个结点
 *
 * 用快慢指针实现，最好在head前面加一个dummyHead，使得要删除的节点永远是slow的下一个节点
 */
public class RemoveNthFromEnd {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, null));
    ListNode ans = removeNthFromEnd(head,1);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = new ListNode(0, head), fast = head, dummy = slow;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
  }

}

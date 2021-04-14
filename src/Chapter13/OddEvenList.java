
package Chapter13;

/**
 * No. 328 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 设置一个奇数node节点和一个偶数node节点，同时更新奇数节点和偶数节点。还要设置一个偶数的头节点，等奇数节点遍历完后再指向偶数头节点
 */
public class OddEvenList {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, null));
    ListNode ans = oddEvenList(head);
    while (ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }

  public static ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode odd = head;
    ListNode evenHead = head.next, even = evenHead;

    while (odd .next != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }

    odd.next = evenHead;
    return head;
  }
}


package Chapter13;


/**
 * No. 234 回文链表
 *
 * 判断一个链表是否是回文链表
 *
 * 方法：利用快慢指针找到链表的中部，然后翻转链表的后半部分，比较值的大小
 * 要注意翻转链表的头节点的位置
 */
public class PalindromeList {

  public static boolean isPalindrome(ListNode head) {
    if (head == null) {
      return false;
    }

    if (head.next == null) {
      return true;
    }
    ListNode slow = head, fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode tail = reverse(slow.next);
    while (tail != null) {
      if (head.val != tail.val) {
        return false;
      }
      head = head.next;
      tail = tail.next;
    }
    return true;

  }

  public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}

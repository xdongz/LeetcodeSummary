
package Chapter13;

import java.util.PriorityQueue;

/**
 * No. 148 排序链表
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {

  //首先想到的方法就是优先队列。
  //但答案中好像几乎没有用这种方法的。可能是因为要求在常数级空间复杂度的情况下吧
  public ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
    ListNode curr = head;
    while (curr != null) {
      queue.offer(curr);
      curr = curr.next;
    }

    ListNode ans = queue.poll();
    curr = ans;
    while (!queue.isEmpty()) {
      curr.next = queue.poll();
      curr = curr.next;
    }
    curr.next = null;
    return ans;
  }

  /**
   * 自底向上归并排序法
   *
   * 所谓自底向上，就是最开始每个子链表的长度是1，然后两两合并，然后再将这长度为2的子链表两两合并，直到链表长度大于或等于链表的总长度为止
   */
  public ListNode method2 (ListNode head) {
    if (head == null) {
      return head;
    }

    int length = 0;
    ListNode node = head;
    // 算出链表的总长度
    while (node != null) {
      length ++;
      node = node.next;
    }

    ListNode dummyHead = new ListNode(0, head);
    //最开始subLength的长度是1，不用排序只合并。此后subLength每循环一次 乘以 2
    for (int subLength = 1; subLength < length; subLength <<= 1) {
      ListNode prev = dummyHead, curr = dummyHead.next;
      while (curr != null) {
        ListNode head1 = curr;
        for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
          curr = curr.next;
        }
        ListNode head2 = curr.next;
        // 切断第一个子链表的尾部
        curr.next = null;
        curr = head2;
        for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
          curr = curr.next;
        }
        ListNode next = null;
        if (curr != null) {
          // 得到第三个链表的头部
          next = curr.next;
          // 切断第二个链表的尾部
          curr.next = null;
        }
        //合并两个有序链表
        ListNode merged = merge(head1, head2);
        prev.next = merged;
        while (prev.next != null) {
          // prev永远指向上一个排好序的链表的最后一个元素
          prev = prev.next;
        }
        // 将第三个链表的头部赋值给curr
        curr = next;
      }
    }
    return dummyHead.next;
  }

  public ListNode merge (ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0), curr = ans;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        curr.next = l2;
        l2 = l2.next;
      } else {
        curr.next = l1;
        l1 = l1.next;
      }
      curr = curr.next;
    }
    curr.next = l1 == null ? l2 : l1;
    return ans.next;
  }

  /**
   * 方法三：自顶向下的归并排序
   * 需要用到递归
   */
  public ListNode method3 (ListNode head) {
    //需要注意的是最开始的tail是null
    return sortList(head, null);
  }

  // 不包含tail在内的有序链表
  public ListNode sortList (ListNode head, ListNode tail) {
    if (head == null) {
      return head;
    }

    if (head.next == tail) {
      head.next = null;
      return head;
    }
    //用快慢指针找到head-tail的中间节点
    ListNode slow = head, fast = head;
    while (fast != tail) {
      slow = slow.next;
      fast = fast.next;
      if (fast != tail) {
        fast = fast.next;
      }
    }
    ListNode mid = slow;
    ListNode list1 = sortList(head, mid);
    ListNode list2 = sortList(mid, tail);
    ListNode sorted = merge(list1, list2);
    return sorted;
  }

}

package Chapter03;

/**
 *
 * No.142 快慢指针
 *
 * 给定一个链表，如果有环路，找出环路的开始点
 *
 * 对于链表找环路的问题，有一个通用的解法——快慢指针（Floyd 判圈法） 。
 * 给定两个指针，分别命名为 slow 和 fast，起始位置在链表的开头。每次 fast 前进两步， slow 前进一步。
 * 如果 fast可以走到尽头，那么说明没有环路；如果 fast 可以无限走下去，那么说明一定有环路，且一定存
 * 在一个时刻 slow 和 fast 相遇。
 * 当 slow 和 fast 第一次相遇时，我们将 fast 重新移动到链表开头，并让 slow 和 fast 每次都前进一步。当 slow 和 fast 第二次相遇时，相遇的节点即为环路的开始点。
 *
 * 他们一定会在慢指针没有走完第一圈的时候相遇。
 * 假设起点到环形入口的距离是a，慢指针走了b，快指针走了a+n(b+c)
 * a+n(b+c) = 2(a+b)
 * a = (n-1)b + nc
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            // 如果fast是null了，那么肯定不是环形链表
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            // 如果是环形链表，那么他们一定会相遇
            if (fast == slow) {
                // 这时让其中一个指针重回起点，然后一起每次只移动一格，相遇的地方即为环形入口
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }

        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

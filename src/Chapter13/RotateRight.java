package Chapter13;

public class RotateRight {
    public static void main(String[] args) {
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        //ListNode head  = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode head = new ListNode(1);
        ListNode ans = rotateRight(head, 5);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = head, tail = head, prev = dummyHead;
        int count = 0;
        // 求出链表的长度
        while (curr != null) {
            count++;
            curr = curr.next;
            if (tail.next != null) {
                tail = tail.next;
            }
        }
        if (count == 0 || k % count == 0) {
            return head;
        }
        // 实际要移动的次数
        k = k % count;
        int index = count - k;
        curr = head;
        while (index > 0) {
            curr = curr.next;
            prev = prev.next;
            index--;
        }
        prev.next = null;
        tail.next = dummyHead.next;
        dummyHead.next = curr;
        return dummyHead.next;
    }
}

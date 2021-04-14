
package Chapter13;

/**
 * No.160 相交链表
 *
 * 假设链表A 的头节点到相交点的距离是a，链表B 的头节点到相交点的距离是b，相交点到链表终点的距离为c。
 * 我们使用两个指针，分别指向两个链表的头节点，并以相同的速度前进，若到达链表结尾，则移动到另一条链表的头节点继续前进。
 * 按照这种前进方法，两个指针会在a + b + c 次前进后同时到达相交节点
 *
 */
public class IntersectionNode {

  public static void main(String[] args) {
    ListNode headA = new ListNode(2, new ListNode(6, new ListNode(4, null)));
    ListNode headB = new ListNode(1, new ListNode(5, null));
    ListNode ans = getIntersectionNode(headA, headB);
    System.out.println(ans.val);
  }

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pA = headA;
    ListNode pB = headB;

    // 注意: 首先要判断pA pB是否为null
    // 循环终止条件，要么有真正的交点，要么都指向null，所以一定要让pA和pB都可能指向null
    while (pA != pB) {
      if (pA == null) {
        pA = headB;
      } else {
        pA = pA.next;
      }

      if(pB == null) {
        pB = headA;
      } else {
        pB = pB.next;
      }
    }
    return pA;
  }

}

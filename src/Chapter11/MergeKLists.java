/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.PriorityQueue;

/**
 * No.23 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 合并两个有序链表的方法：分别取头节点的值，把较小的值放入结果并把对应链表的指针后移一位，然后比较两个链表当前指针指向的值
 * 直到某个链表的当前指针为空
 */
public class MergeKLists {

  //这里我们用的是优先队列的方法
  public ListNode mergeKLists(ListNode[] lists) {
    //优先队列默认是按降序排列，但我们要改成按增序排列
    PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
    //先把所有的头节点的值按从小到大顺序放进队列
    for (ListNode node : lists) {
      if (node != null) {
        queue.offer(node);
      }
    }

    ListNode head = new ListNode(0);
    ListNode curr = head;
    while (!queue.isEmpty()) {
      //每次得到队列中值最小的那个节点，并得到它的下一个节点，按照增序放入队列中
      curr.next = queue.poll();
      curr = curr.next;
      if (curr.next != null) {
        queue.offer(curr.next);
      }
    }
    return head.next;
  }
}


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


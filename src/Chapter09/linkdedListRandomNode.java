/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

import java.util.Random;

/**
 * No.382
 * 给定一个单向链表，要求设计一个算法，可以随机取得其中一个节点的值
 */
public class linkdedListRandomNode {

  ListNode head;

  Random rand = new Random();
  public linkdedListRandomNode(ListNode head) {
    this.head = head;
  }

  /**
   * 水库算法： 遍历一次链表，在遍历到第m个节点时，有1/m的概率覆盖掉之前的节点选择；
   *
   * @return
   */
  public int getRandom() {
    int ans = head.val;
    //一定要创建一个新的链表，不然多次调用getRandom函数，链表会不一样
    ListNode node = head.next;

    int count = 2;

    while (node != null) {
      int random = rand.nextInt(count);
      //为了创造1/m的概率，这里不一定是0，可以是[0,count-1]中间的任意的数
      if (random == 0) {
        //有1/m的几率去替换原先的节点选择
        ans = node.val;
      }
      count ++;
      node = node.next;
    }
    return ans;
  }

}

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

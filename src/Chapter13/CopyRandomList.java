
package Chapter13;

import java.util.HashMap;
import java.util.Map;

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

/**
 * No.138 复制带随机指针的链表
 *
 * 这道题最关键的是random指针，因为有可能当前节点的随机指针指向的节点还未创建
 *
 */
public class CopyRandomList {

  // 方法一： 用HashMap先将节点复制一遍，然后再建立对应的关系
  public Node copyRandomList(Node head) {

    // 1. 建立一个map，key是原节点，value是新节点
    Map<Node, Node> map = new HashMap<>();

    // 2. 遍历原节点，将原节点和新节点存入map
    Node origin = head;
    while (origin != null) {
      Node newNode = new Node(origin.val);
      map.put(origin, newNode);
      origin = origin.next;
    }

    // 3. 遍历原节点，根据原节点的关系建立新节点的关系
    origin = head;
    while (origin != null) {
      Node next = origin.next;
      Node random = origin.random;
      map.get(origin).next = map.get(next);
      map.get(origin).random = map.get(random);
      origin = origin.next;
    }
    return map.get(head);
  }

  // 方法二：不使用hashmap
  public Node method2(Node head) {

    if (head == null) {
      return null;
    }

    // 1. 在每个节点后面插入一个复制的节点，例如1->2->3变成1->1'->2->2'->3->3'
    Node origin = head;
    while (origin != null) {
      Node newNode = new Node(origin.val);
      newNode.next = origin.next;
      origin.next = newNode;
      origin = newNode.next;
    }

    // 2. 建立复制节点1',2',3'之间random指针的关系1'的random指向的是1的random的next
    origin = head;
    while (origin != null) {
      if (origin.random != null) {
        origin.next.random = origin.random.next;
      }
      origin = origin.next.next;
    }

    // 3. 分离原节点和复制的节点，原来的链表结构不能改变
    origin = head;
    Node dummy = new Node(-1);
    Node curr = dummy;
    while (origin != null) {
      curr.next = origin.next;
      curr = curr.next;
      origin.next = curr.next;
      origin = origin.next;
    }
    return dummy.next;
  }

}

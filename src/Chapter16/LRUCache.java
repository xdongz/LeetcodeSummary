/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter16;

import java.util.HashMap;
import java.util.Map;

/**
 * No.146 LRU 缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 */
public class LRUCache {
  // 双向链表, 存放着键值对，最近使用的放在头部，最久没使用的放在尾部，每次删除都是删尾部，每次操作都会将结点放在头部
  class DLinkNode {
    int key;
    int value;
    DLinkNode prev;
    DLinkNode next;
    public DLinkNode() {}
    public DLinkNode(int key, int value) {
      this.key = key;
      this.value = value;
    }

  }

  private Map<Integer, DLinkNode> cacheMap = new HashMap<>();
  private int capacipty;
  private int size;
  // 设置两个dummy结点，放在头和尾，方便操作
  private DLinkNode head;
  private DLinkNode tail;

  public LRUCache(int capacipty) {
    this.capacipty = capacipty;
    this.size = 0;
    head = new DLinkNode();
    tail = new DLinkNode();
    head.next = tail;
    tail.prev = head;

  }

  public int get(int key) {
    DLinkNode node = cacheMap.get(key);
    if (node == null) {
      return -1;
    }

    // 在return之前需要把这个结点移动到双向链表的头部
    moveToHead(node);

    return node.value;
  }


  public void put(int key, int value) {
    DLinkNode node = cacheMap.get(key);
    // 如果map中没有node，就先把node插入链表中，然后再把node放入map中
    if (node == null) {
      node = insert(key, value);
      cacheMap.put(key, node);
      // 如果有该node，就把node移到头部，然后更新值
    } else {
      moveToHead(node);
      node.value = value;
    }
  }

  // 向双向链表中插入node
  private DLinkNode insert(int key, int value) {
    DLinkNode node = new DLinkNode(key, value);
    // 如果满了，就先删除尾部结点，map中也要删除对应的结点，size减一
    if (size == capacipty) {
      DLinkNode removeNode = removeTail();
      cacheMap.remove(removeNode.key, removeNode);
      size --;
    }

    // 在链表头节点中插入新元素
    addToHead(node);
    size++;
    return node;
  }

  // 把结点加入到头部
  private void addToHead(DLinkNode node) {
    DLinkNode node1 = head.next;
    head.next = node;
    node.next = node1;
    node1.prev = node;
    node.prev = head;
  }

  // 把新操作的结点移到头部
  private void moveToHead(DLinkNode node) {
    removeNode(node);
    addToHead(node);
  }

  // 删除某个结点
  private void removeNode(DLinkNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  // 删除尾部结点
  private DLinkNode removeTail() {
    DLinkNode res = tail.prev;
    removeNode(res);
    return res;
  }

}




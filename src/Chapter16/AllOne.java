package Chapter16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.432 全O(1) 的数据结构
 * 此题和LRUCache有点像，也是map+双向链表，只不过用了两个map
 */
public class AllOne {

    // 双向链表的头部是最小值，尾部是最大值，keys中存放相同值的key
    class DLinkNode {
        Set<String> keys;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(Set<String> keys, int value) {
            this.keys = keys;
            this.value = value;
        }
    }

    // 键值对map
    Map<String, Integer> map1;
    // key是值，value是对应的node结点
    Map<Integer, DLinkNode> map2;
    DLinkNode head;
    DLinkNode tail;

    /** Initialize your data structure here. */
    public AllOne() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // 如果map1中包含这个key
        if (map1.containsKey(key)) {
            int value = map1.get(key);
            map1.put(key, value + 1);
            // 从map2中拿到原先value对应的node
            DLinkNode node = map2.get(value);
            // 从node结点中的keyset中删掉该key，因为它的值已经变了。
            node.keys.remove(key);
            // 拿到node结点后一个结点，这个结点的值要么比node大，要么这个结点已经是tail了
            DLinkNode next = node.next;
            // 如果下一个结点是tail，或者下一个结点的值大于value+1，那么直接在node和next中间插入新结点
            if (next == tail || next.value > value + 1) {
                Set<String> keys = new HashSet<>();
                keys.add(key);
                DLinkNode newNode = new DLinkNode(keys, value + 1);
                insertNode(newNode, node, next);
                map2.put(value + 1, newNode);
            } else {
                // 如果下一个的结点的值等于value+1，直接更新对应的keyset
                next.keys.add(key);
            }
            // 如果原结点在移除之后keyset为空了，那么要把该结点从链表中删除
            if (node.keys.size() == 0) {
                removeNode(node);
                map2.remove(value);
            }
        } else {
            // 如果map1中没有这个key，便把值为1的key加入到map中
            map1.put(key, 1);
            DLinkNode node = map2.get(1);
            // 如果node是空，那么把node加入到链表头部，因为1是最小的value
            if (node == null) {
                Set<String> keys = new HashSet<>();
                keys.add(key);
                node = new DLinkNode(keys, 1);
                insertNode(node, head, head.next);
                map2.put(1, node);
            } else {
                node.keys.add(key);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        // 如果该key不存在，直接return
        if (map1.containsKey(key)) {
            int value = map1.get(key);
            DLinkNode node = map2.get(value);
            // 从node中删除该key
            node.keys.remove(key);
            // 如果key对应的值是1，删除该key
            if (map1.get(key) == 1) {
                map1.remove(key);
            } else {
                // 如果值不为1，那么从数据结构中把值减1
                map1.put(key, value - 1);
                DLinkNode prev = node.prev;
                // 前一个结点，要么是head，要么值小于value
                if (prev == head || prev.value < value - 1) {
                    // 如果值是head，或者值小于value - 1，在prev和node之间插入新结点
                    Set<String> keys = new HashSet<>();
                    keys.add(key);
                    DLinkNode newNode = new DLinkNode(keys, value - 1);
                    insertNode(newNode, prev, node);
                    map2.put(value - 1, newNode);
                } else {
                    prev.keys.add(key);
                }
            }
            if (node.keys.size() == 0) {
                removeNode(node);
                map2.remove(value);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    private void insertNode(DLinkNode node, DLinkNode n1, DLinkNode n2) {
        n1.next = node;
        node.next = n2;
        n2.prev = node;
        node.prev = n1;
    }

    private void removeNode(DLinkNode node) {
        DLinkNode prev = node.prev;
        DLinkNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

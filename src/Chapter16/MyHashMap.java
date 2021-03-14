package Chapter16;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    class LinkedNode {
        int key;
        int val;
        public LinkedNode() {}
        public LinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int BASE = 769;
    LinkedList[] linkedList;

    /** Initialize your data structure here. */
    public MyHashMap() {
        linkedList = new LinkedList[BASE];
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkedList<LinkedNode>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<LinkedNode> iterator = linkedList[hash].iterator();
        while (iterator.hasNext()) {
            LinkedNode node = iterator.next();
            if (node.key == key) {
                node.val = value;
                return;
            }
        }

        linkedList[hash].add(new LinkedNode(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);

        Iterator<LinkedNode> iterator = linkedList[hash].iterator();
        while (iterator.hasNext()) {
            LinkedNode node = iterator.next();
            if (node.key == key) {
                return node.val;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        Iterator<LinkedNode> iterator = linkedList[hash].iterator();
        while (iterator.hasNext()) {
            LinkedNode node = iterator.next();
            if (node.key == key) {
                linkedList[hash].remove(node);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % BASE;
    }
}

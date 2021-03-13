package Chapter16;

import java.util.LinkedList;

/**
 * No. 705 设计哈希集合
 *
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 */
public class MyHashSet {

    // 链表数组，用于解决hash冲突
    LinkedList[] list;
    // base需要取一个质数
    int BASE = 769;

    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        if (list[hash] != null && list[hash].contains(key)) {
            return;
        }
        list[hash].add(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        if (list[hash] != null) {
            list[hash].remove((Integer) key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        if (list[hash] != null && list[hash].contains(key)) {
            return true;
        }
        return false;
    }

    private int hash(int val) {
        return val % BASE;
    }
}

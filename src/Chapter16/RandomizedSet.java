package Chapter16;

import java.util.*;

/**
 * No. 380 常数时间插入、删除和获取随机元素
 *
 * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * 虽然哈希表提供常数时间的插入和删除，但是实现getRandom的时候会出现问题，因为哈希表中没有索引。
 * 所以我们需要将哈希表和列表结合起来使用解决此问题。
 * 而列表中要想删除动作的时间复杂度是O(1)，那么要删除最后一个元素，所以每次删除元素的时候，把要删除元素
 * 位置的索引替换成最后元素，然后再删除最后一个元素即可。
 * 加入的时候也是在列表最后加入元素
 */
public class RandomizedSet {
    // Map的key是要加入的元素的值，value是list中对应val的索引
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        // 把新元素加入到list的最末尾
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int lastEle = list.get(list.size() - 1);
        int idx = map.get(val);
        // 把要删除的元素替换成最后一个元素，然后删除最后一个元素即可，这样操作的时间复杂度是O(1)
        list.set(idx, lastEle);
        map.put(lastEle, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

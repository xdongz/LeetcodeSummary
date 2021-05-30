package Chapter11;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) != map.get(o2)) {
                    return map.get(o2) - map.get(o1);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        Set<String> keys = map.keySet();
        for (String key : keys) {
            priorityQueue.add(key);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }
}

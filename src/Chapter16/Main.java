
package Chapter16;

import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    MyHashMap map = new MyHashMap();
    map.put(1,1);
    map.put(2,2);
    System.out.println(map.get(1));
    System.out.println(map.get(3));
    map.put(2,1);
    System.out.println(map.get(2));
    map.remove(2);
    System.out.println(map.get(2));
//    AllOne allOne = new AllOne();
//    allOne.inc("hello");
//    allOne.inc("world");
//    allOne.inc("hello");
//    allOne.dec("world");
//    allOne.inc("hello");
//    allOne.inc("leet");
//    System.out.println(allOne.getMaxKey());
//    allOne.dec("hello");
//    allOne.dec("hello");
//    allOne.dec("hello");
//
//    System.out.println(allOne.getMaxKey());

//    LRUCache cache = new LRUCache(2);
//    cache.put(1,1);
//    cache.put(2,2);
//    System.out.println(cache.get(1));
//    cache.put(3,3);
//    System.out.println(cache.get(2));
//    cache.put(4,4);
//    System.out.println(cache.get(1));
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(4));
  }

}

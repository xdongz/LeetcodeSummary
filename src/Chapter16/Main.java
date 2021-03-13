/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter16;

public class Main {

  public static void main(String[] args) {
    MyHashSet set = new MyHashSet();
    set.add(1);
    set.add(2);
    set.add(2);
    set.remove(2);
    System.out.println(set.contains(2));
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

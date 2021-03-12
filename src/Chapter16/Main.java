/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter16;

public class Main {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1,1);
    cache.put(2,2);
    System.out.println(cache.get(1));
    cache.put(3,3);
    System.out.println(cache.get(2));
    cache.put(4,4);
    System.out.println(cache.get(1));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
  }

}

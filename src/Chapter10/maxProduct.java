/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * No.318
 * 找出字符串数组中最大两个单词长度乘积，但这两个单词不含公共字母
 *
 * 为每个字母建立一个长度为26的二进制数组，每个位置表示是否存在该字母，a存在，最低位为1，z存在，最高位为1
 * 这道题的难点在于，要想到，如果两个字符串没有公共字母，那么他们的二进制表示按位与一定是0
 */
public class maxProduct {

  public static void main(String[] args) {
    String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
    System.out.println(maxProduct(words));
  }

  public static int maxProduct(String[] words) {
    //创建一个hashMap存储mask和单词长度的映射关系
    Map<Integer, Integer> map = new HashMap<>();
    int maxSize = 0;
    for (String word : words) {
      int mask = 0;
      for (int i = 0; i < word.length(); i ++) {
        char c  = word.charAt(i);
        //通过mask上哪些位是1，可以得出存在哪些字母
        mask = mask | (1 << (c - 'a'));
      }

      Set<Integer> keySet =  map.keySet();
      if (!keySet.isEmpty()) {
        for (int key : keySet) {
          //如果按位与司0，那么他们一定没有公共字母，就可以求他们的size乘积了
          if ((mask & key) == 0) {
            maxSize = Math.max(maxSize, map.get(key) * word.length());
          }
        }
      }
      //最后还有一个重点： 有可能有字符串计算出的mask一样，但长度却不一样，所以我们要去长度最长的那个字符串
      map.put(mask, Math.max(map.getOrDefault(mask, 0), word.length()));
    }

    return maxSize;
  }
}

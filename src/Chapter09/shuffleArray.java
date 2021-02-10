/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter09;

import java.util.Random;

/**
 * 给定一个数组，要求实现两个指令函数。
 * shuffle函数可以随机打乱这个数组
 * reset函数可以重置这个数组
 * No.384
 */
public class shuffleArray {

  private int[] original;
  private int[] array;

  Random rand = new Random();

  //在(min, max)范围内随机生成一个数
  public int randomRange(int min, int max) {
    return rand.nextInt(max - min) + min;
  }

  public void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public shuffleArray(int[] nums) {
    array = nums;
    original = nums.clone();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return original;
  }

  /** Returns a random shuffling of the array. */
  //Fisher-Yates洗牌法。
  //其实就是把当前位置的元素和这个元素之后的随机某个元素交换位置
  public int[] shuffle() {
    for (int i = 0; i < array.length; i ++) {
      swap(i, randomRange(i, array.length), array);
    }
    return array;
  }

}

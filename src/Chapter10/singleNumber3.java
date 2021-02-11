/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter10;

/**
 * No.260
 * 给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次，找出只出现一次的那两个元素
 *
 * 这种题目一个比较通用的方法是用set，如果num没出现，就加进set，如果又遇到了就把num移除，那么剩下的就是只出现一次的元素
 * 但是如何用位运算呢？
 */
public class singleNumber3 {

  /**
   * 位运算的方法比较巧妙，就是把数组分成两个数组，每个数组只包含一个出现一次的数
   * 最关键的点在于如何把这两个不同的数分在不同的组。假设这两个不同的数字是a和b，我们可以根据a和b的互斥条件来将他们分在不同的数组中
   * 1.首先给nums中所有的数求异或，那么这个异或值其实等于a ^ b.将这个异或值记作n
   * 2.我们可以通过 n & (-n)来得到最后n的最后一位1，这就说明a和b在这一位不一样了，根据这个互斥条件就可以分组。（当然也可以找其他为1的位）
   * 3.将与这一位不为0的数分在一个组，相与为0的数分在另一个组，那么a和b肯定在不同的组，相同的数组又肯定在同一个组
   *
   * @param nums 输入的整数数组
   * @return 输出唯一出现两个元素的
   */
  public int[] singleNumber(int[] nums) {

    //1.首先求出异或值
    int xor = 0;
    for (int n : nums) {
      xor ^= n;
    }

    //2.求出xor中最低位的那个1，以此来分组，这个diff会是 0...010....0
    int diff = xor & (-xor);

    int a = 0, b = 0;
    for (int n : nums) {
      //该位为0的在一组
      if ((n & diff) == 0) {
        a ^= n;
      } else {
        //该位为1的在一组
        b ^= n;
      }
    }
    return new int[] {a, b};
  }
}

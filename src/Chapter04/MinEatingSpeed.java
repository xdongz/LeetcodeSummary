
package Chapter04;

import java.util.Arrays;

/**
 * No. 875 爱吃香蕉的珂珂
 *
 * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 此题解题思路和1011一样
 */
public class MinEatingSpeed {

  public static void main(String[] args) {
    int[] piles = {30,11,23,4,20};
    System.out.println(minEatingSpeed(piles, 6));

  }

  public static int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = Arrays.stream(piles).max().getAsInt();

    while (left < right) {
      int mid = (left + right) / 2;

      int hour = 0;
      for (int pile : piles) {
        hour += pile % mid == 0 ? pile / mid : pile / mid + 1;
      }
      if (hour > h) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

}

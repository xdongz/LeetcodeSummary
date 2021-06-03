package Chapter02;

import java.util.Arrays;

/**
 * No.1774 你能在你最喜欢的那天迟到你最喜欢的糖果吗
 *
 * 这道题很简单，就是先求前缀和然后再判断界限。需要注意的是从第0天开始吃糖果
 */
public class CanEat {

  public static void main(String[] args) {
    int[] candiesCount =
        {16,38,8,41,30,31,14,45,3,2,24,23,38,30,31,17,35,4,9,42,28,18,37,18,14,46,11,13,19,3,5,39,24,48,20,29,4,19,36,11,28,49,38,16,23,24,4,22,29,35,45,38,37,40,2,37,8,41,33,8,40,27,13,4,33,5,8,14,19,35,31,8,8};
    int[][] queries = {{43,1054,49}};
    System.out.println(Arrays.toString(canEat(candiesCount, queries)));
  }

  public static boolean[] canEat(int[] candiesCount, int[][] queries) {
    int n = queries.length;
    boolean[] answer = new boolean[n];
    long[] preSum = new long[candiesCount.length];
    preSum[0] = candiesCount[0];

    for (int i = 1; i < candiesCount.length; i++) {
      preSum[i] = candiesCount[i] + preSum[i-1];
    }

    for (int i = 0; i < n; i++) {
      int[] query = queries[i];
      int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

      long x1 = favoriteDay+1;
      long y1 = (long) (favoriteDay + 1) * dailyCap;
      long x2 = favoriteType == 0 ? 1 : preSum[favoriteType - 1] + 1;
      long y2 = preSum[favoriteType];

      answer[i] = !(x1 > y2 || y1 < x2);

    }
    return answer;
  }

}



package Chapter02;

import java.util.Arrays;

/**
 * No.881 救生艇
 *
 * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 加上每艘船最多同时载两人，就很简单了。
 *
 */
public class NumRescueBoats {

  public static void main(String[] args) {
    int[] people = {2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10,50};
    int limit = 50;
    System.out.println(numRescueBoats(people, limit));
  }

  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int l = 0, r = people.length - 1, count = 0;
    while (r >= l) {

      int sum = people[r] + people[l];
      if (sum <= limit) {
        l++;
      }

      count++;
      r--;
    }
    return count;
  }

}

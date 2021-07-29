
package Chapter07;

import java.util.Arrays;

public class MaxIceCream {

  public static void main(String[] args) {
    int[] costs = {1,6,3,1,2,5};
    int coins = 20;
    System.out.println(maxIceCream(costs, coins));
  }

  public static int maxIceCream(int[] costs, int coins) {
    int max = 0;
    Arrays.sort(costs);
    for (int cost : costs) {
      if (cost <= coins) {
        max++;
        coins -= cost;
      } else {
        break;
      }
    }
    return max;
  }

}


package Chapter04;

import java.util.Arrays;

/**
 * No.1011 在D天内送达包裹的能力
 *
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 解题思路： 假设船的运载能力为x时符合题目要求，那么x一定大于等于weight数组中的最大值，且小于等于weight数组总和
 * 所以用二分法来查找x的值
 *
 */
public class ShipWithinDays {

  public static void main(String[] args) {
    int[] weight = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(shipWithinDays(weight, 5));
  }

  public static int shipWithinDays(int[] weights, int D) {
    int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
    while (left < right) {
      // 假设x=mid
      int mid = (left + right) / 2;

      // 计算所需要的天数和当前的重量和
      int day = 1, curr = 0;
      for (int weight : weights) {
        if (curr + weight <= mid) {
          curr += weight;
        } else {
          day ++;
          curr = weight;
          // 如果天数超过了规定的D，那么就说明此时的x太小了
          if (day > D) {
            left = mid + 1;
            break;
          }
        }
      }
      if (day <= D) {
        right = mid;
      }
    }
    return left;
  }

}

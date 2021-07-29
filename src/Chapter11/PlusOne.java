
package Chapter11;

import java.util.Arrays;

public class PlusOne {

  public static void main(String[] args) {
    int[] digits = {9,1,9,9,9};
    System.out.println(Arrays.toString(plusOne(digits)));
  }

  public static int[] plusOne(int[] digits) {
    int n = digits.length;
    if (digits[n-1] < 9) {
      digits[n-1] += 1;
      return digits;
    } else {
      int i = n-1;
      while (i >= 0) {
        if (digits[i] == 9) {
          digits[i] = 0;
          i--;
        } else {
          digits[i] += 1;
          break;
        }
      }
    }
    if (digits[0] == 0) {
      int[] ans = new int[n+1];
      Arrays.fill(ans, 0);
      ans[0] = 1;
      return ans;
    }
    return digits;
  }

}

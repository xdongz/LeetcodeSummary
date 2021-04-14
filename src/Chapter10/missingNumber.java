
package Chapter10;

/**
 * No.268
 * 找到[0, n]中没有出现在数组中的那个数
 * 这道题与singleNumber有异曲同工之妙
 */
public class missingNumber {

  public int missingNumber(int[] nums) {
    int ans = nums.length;
    for (int i = 0; i < nums.length; i++) {
      ans ^= i;
      ans ^= nums[i];
    }
    return ans;
  }
}

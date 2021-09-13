
package Chapter04;

/**
 * No. 153 寻找旋转数组中的最小值
 *
 * 这道题和154题解题思路一样
 */
public class FindMin {

  public static void main(String[] args) {
    int[] nums = {20,21,19,19,19,19};
    System.out.println(findMin(nums));
  }

  public static int findMin(int[] nums) {
    int l = 0, r = nums.length - 1, mid;
    while (l < r) {
      mid = (l + r) / 2;
      // 说明左边是增序的，那么最小值在右侧
      if (nums[mid] > nums[r]) {
        l = mid + 1;
      } else if (nums[mid] < nums[r]) {
        r = mid;
      } else {
        r--;
      }
    }
    return nums[l];
  }

}

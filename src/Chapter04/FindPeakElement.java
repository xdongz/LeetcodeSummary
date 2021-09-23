package Chapter04;

/**
 * No.162 寻找峰值
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 因为时间复杂度的限制，所以首先想到二分法，然后再加上爬坡，如果后一个元素比自己大，那么峰值肯定在右边，否则就在左边
 */
public class FindPeakElement {
  public static void main(String[] args) {
    int[] nums = {1,2,1,3,5,6,4};
    System.out.println(findPeakElement(nums));
  }
  public static int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int l = 0, r = nums.length-1;
    while (l <= r) {
      int mid = (l+r)/2;
      if (mid == 0 && nums[mid] > nums[mid+1]) {
        return mid;
      } else if (mid == nums.length-1 && nums[mid] > nums[mid -1]) {
        return mid;
      } else if (nums[mid] < nums[mid+1]) {
        // 处于上坡,向右走
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }


}

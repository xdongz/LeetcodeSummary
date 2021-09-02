
package Chapter04;

public class Search {

  public static void main(String[] args) {
    int[] nums = {1};
    System.out.println(search(nums, 1));
  }

  public static int search(int[] nums, int target) {
    int left = 0, right = nums.length-1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] == target) {
        return mid;
      } else {
        if (nums[mid] < nums[right]) {
          if (target > nums[mid] && target <= nums[right]) {
            left = mid+1;
          } else {
            right = mid-1;
          }
        } else {
          if (target < nums[mid] && target >= nums[left]) {
            right = mid-1;
          } else {
            left = mid+1;
          }
        }
      }
    }
    return -1;
  }

}

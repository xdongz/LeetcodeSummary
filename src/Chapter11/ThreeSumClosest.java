
package Chapter11;

import java.util.Arrays;

/**
 * No.16 最接近的三数之和
 *
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 和第18题，四数之和的解题思路一样
 *
 */
public class ThreeSumClosest {

  public static void main(String[] args) {
    int[] nums = {1,1,-1,-1,3};
    System.out.println(threeSumClosest(nums, 3));
  }

  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    int res = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < n-2; i++) {
      if (i > 0 && nums[i] == nums[i-1]) {
        continue;
      }
      if (nums[i] + nums[i+1] + nums[i+2] > target) {
        if (Math.abs(nums[i] + nums[i+1] + nums[i+2] - target) < Math.abs(res - target)) {
          res = nums[i] + nums[i+1] + nums[i+2];
        }
        break;
      }

      if (nums[i] + nums[n-1] + nums[n-2] < target) {
        if (Math.abs(nums[i] + nums[n-1] + nums[n-2] - target) < Math.abs(res - target)) {
          res = nums[i] + nums[n-1] + nums[n-2];
        }
        continue;
      }
      int l = i+1, r = n-1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum == target) {
          return target;
        }
        if (Math.abs(sum - target) < Math.abs(res - target)) {
          res = sum;
        }

        if (sum < target) {
          while (l < r && nums[l+1] == nums[l]) {
            l++;
          }
          l++;
        } else {
          while (l < r && nums[r] == nums[r-1]) {
            r--;
          }
          r--;
        }
      }
    }
    return res;
  }

}

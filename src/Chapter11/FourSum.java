
package Chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.18 四数之和
 *
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 *
 * 这道题思路不难，就是要注意去重和剪枝
 */
public class FourSum {

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    System.out.println(fourSum(nums, -1));
  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n-3; i++) {
      // 去重
      if (i > 0 && nums[i] == nums[i-1]) {
        continue;
      }
      // 最小的四个数都大于target了，后面更加大于target
      if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
        break;
      }

      // 最大的三个数和此数相加都小于target，其余的更加小于target
      // 所以直接进入j+1
      if (nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) {
        break;
      }

      int a = nums[i];
      for (int j = i+1; j < n-2; j++) {
        int b = nums[j];
        // 去重
        if (j > i+1 && nums[j] == nums[j-1]) {
          continue;
        }
        // 最小的四个数都大于target了，后面更加大于target
        if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
          continue;
        }

        // 最大的三个数和此数相加都小于target，其余的更加小于target
        // 所以直接进入j+1
        if (nums[i] + nums[j] + nums[n-1] + nums[n-2] < target) {
          continue;
        }
        int sum = target - (a + b);
        int l = j + 1, r = n - 1;
        while (l < r) {
          int c = nums[l], d = nums[r];
          if (c + d == sum) {
            res.add(Arrays.asList(a, b, c, d));
            // 去重
            while (l < r && nums[l] == nums[l+1]) {
              l++;
            }
            while (l < r && nums[r] == nums[r-1]) {
              r--;
            }
            l ++;
          } else if (c + d < sum) {
            l ++;
          } else {
            r --;
          }
        }
      }
    }
    return res;
  }

}

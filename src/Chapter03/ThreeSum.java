
package Chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15 三数之和
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组
 *
 */
public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
    List<List<Integer>> res = threeSum(nums);
    for (List<Integer> ans : res) {
      System.out.println(ans);
    }
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length < 3) {
      return res;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length-2; i++) {

      while (i > 0 && i < nums.length-2 && nums[i] == nums[i-1]){
        i++;
      }
      int sum = -nums[i];
      List<Integer> path = new ArrayList<>();
      int j = i+1, k = nums.length-1;
      while (j < k) {
        if (nums[j] + nums[k] == sum) {
          path.add(nums[i]);
          path.add(nums[j]);
          path.add(nums[k]);
          res.add(new ArrayList<>(path));
          path.clear();
          while (j < k && nums[j] == nums[++j]) ;
          while (j < k && nums[k] == nums[--k]) ;
        } else if (nums[j] + nums[k] < sum) {
          while (j < k && nums[j] == nums[++j]) ;
        } else {
          while (j < k && nums[k] == nums[--k]) ;
        }
      }

    }

    return res;
  }

}

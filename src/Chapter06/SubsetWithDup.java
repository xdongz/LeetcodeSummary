
package Chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.90 子集II
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 组合的回溯算法，参见CombinationSum2 的解法
 */
public class SubsetWithDup {

  public static void main(String[] args) {
    int[] nums = {1,2,2};
    List<List<Integer>> res = subsetsWithDup(nums);
    System.out.println(res);
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    int n = nums.length;
    Arrays.sort(nums);
    boolean[] used = new boolean[n];
    List<Integer> path = new ArrayList<>();
    helper(nums, res, path, used, -1, 0);
    return res;
  }

  public static void helper(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used, int index, int level) {
    if (level == nums.length) {
      return;
    }

    for (int i = index+1; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
        continue;
      }
      used[i] = true;
      path.add(nums[i]);
      // 与全排列不同的是，在这里就要把path加入到res中了
      res.add(new ArrayList<>(path));
      helper(nums, res, path, used, i, level+1);
      used[i] = false;
      path.remove(level);
    }
  }

}

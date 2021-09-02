package Chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * No.78 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 *
 * 经典的回溯。组合的解法
 */
public class Subsets {

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<List<Integer>> res = subsets(nums);
    for (List<Integer> i : res) {
      System.out.println(i);
    }
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backtracking(res, path, nums, -1);
    return res;
  }


  public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums,
      int index) {
    res.add(new ArrayList<>(path));

    // 这个判断条件加不加无所谓
//    if (index == nums.length-1) {
//      return;
//    }
    for (int i = index+1; i < nums.length; i++) {
      path.add(nums[i]);
      backtracking(res, path, nums, i);
      path.remove(path.size()-1);
    }
  }

}

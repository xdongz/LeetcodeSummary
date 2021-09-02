
package Chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * No. 39 组合总和
 *
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的数字可以无限制重复被选取。
 *
 * 这道题其实就是普通的回溯，只不过可以允许一个数被重复用多次，所以就将普通回溯的下一次搜索起点的 i+1改为 i
 */
public class combinationSum {

  public static void main(String[] args) {
    int[] candidates = {2,3,6,7};
    List<List<Integer>> res = combinationSum(candidates, 7);
    for (List<Integer> r : res) {
      System.out.println(r);
    }
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    //Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backtracking2(res, path, candidates, target, 0);
    return res;

  }

  // 方法一：
  public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates,
      int target, int level, int sum) {
    if (sum == target) {
      res.add(new ArrayList<>(path));
      return;
    }

    if (sum > target) {
      return;
    }

    for (int i = level; i < candidates.length; i++) {
      sum += candidates[i];
      path.add(candidates[i]);
      // 下一次搜索仍然是以i为起点
      backtracking(res, path, candidates, target, i, sum);
      sum -= candidates[i];
      path.remove(path.size()-1);
    }
  }

  //方法二：
  public static void backtracking2(List<List<Integer>> res, List<Integer> path, int[] candidates,
      int target, int idx) {
    if (idx == candidates.length) {
      return;
    }
    if (target == 0) {
      res.add(new ArrayList<>(path));
      return;
    }

    // 直接跳过candidate[idx]
    backtracking2(res, path, candidates, target, idx+1);

    // 加入candidate[idx]
    if (candidates[idx] <= target) {
      path.add(candidates[idx]);
      backtracking2(res, path, candidates, target-candidates[idx], idx);
      path.remove(path.size()-1);
    }
  }

}

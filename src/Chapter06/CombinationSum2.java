package Chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No. 组合总和II
 *
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 这道题是47题和77题的结合
 * 注意：组合和排列的区别
 * 排列每次取元素的时候都是从0-n之间取，去掉取过的数
 * 组合每次都是从i+1-n之间取
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        //int[] candidates = {10,1,2,7,6,1,5};
        int[] candidates = {2,5,2,1,2};
        List<List<Integer>> ans = combinationSum2(candidates, 5);
        System.out.println(ans);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        // 有重复的数一定要排序
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();
        backtracking(candidates, target, res, used, path, 0, -1, 0);
        return res;
    }

    public static void backtracking (int[] candidates, int target, List<List<Integer>> res, boolean[] used, List<Integer> path, int sum, int index, int level) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        // 一定是从当前索引的后一个位置到末尾中拿元素，避免出现 1 2 3 和 1 3 2这样的情况
        for (int i = index+1; i < candidates.length; i++) {
//            if (used[i]) {
//                continue;
//            }
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) {
                continue;
            }
            if (candidates[i] <= target) {
                used[i] = true;
                path.add(candidates[i]);
                sum += candidates[i];
                backtracking(candidates, target, res, used, path, sum, i,level+1);
                sum = sum - candidates[i];
                path.remove(level);
                used[i] = false;
            }
        }
    }
}

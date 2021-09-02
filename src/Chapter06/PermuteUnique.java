package Chapter06;

import java.util.*;

/**
 * No.47 全排列II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 全排列肯定用回溯，但是它与46题不同的是，它是在path中添加元素，同时去重
 */
public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        backtracking(nums, res, path, used, 0);
        return res;
    }
    public static void backtracking(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used, int level) {
        if (level == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 本层要做的事：从数组中取一个数加入到path中
        for (int i = 0; i < nums.length; i++) {
            // 如果该数已经被取过了，那就跳过
            if (used[i]) {
                continue;
            }
            // 重复的数要限制访问顺序，如果前一个数没有被访问，那么它是有可能出现在该数后面的，这种情况重复了
            // 举个栗子，对于两个相同的数11，我们将其命名为1a1b, 1a表示第一个1，1b表示第二个1；
            // 那么，不做去重的话，会有两种重复排列 1a1b, 1b1a， 我们只需要取其中任意一种排列；
            // 为了达到这个目的，限制一下1a, 1b访问顺序即可。
            // 比如我们只取1a1b那个排列的话，只有当visit nums[i-1]之后我们才去visit nums[i]， 也就是如果!visited[i-1]的话则continue
            // 如果去掉这一行，就是46 题了
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            // 如果取了元素就置为true
            used[i] = true;
            path.add(nums[i]);
            // 下层要做的事
            backtracking(nums, res, path, used, level+1);
            // 恢复本层的状态
            used[i] = false;
            path.remove(level);
        }
    }
}


package Chapter14;

import java.util.HashMap;
import java.util.Map;

/**
 * No.437 路径总和III
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathNum3 {

  /**
   * 方法一： 双重递归
   */
  public int pathSum(TreeNode root, int sum) {
    return root == null ? 0 : pathSumStartWithRoot(root, sum) +
        pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  public int pathSumStartWithRoot(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    int count = root.val == sum ? 1 : 0;
    // 一层一层地减当前节点的值
    count += pathSumStartWithRoot(root.left, sum - root.val);
    count += pathSumStartWithRoot(root.right, sum - root.val);

    return count;
  }

  /**
   * 前缀和 ＋ 回溯
   */
  public int method2(TreeNode root, int sum) {
    // key是前缀和， value是大小为key的前缀和出现的次数
    Map<Integer, Integer> prefixSumCount = new HashMap<>();
    // 前缀和为0的一条路径
    prefixSumCount.put(0, 1);
    //前缀和的递归回溯
    return recursionPathSum(root, prefixSumCount, sum, 0);

  }

  public int recursionPathSum(TreeNode root, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
    // 1.递归终止条件
    if (root == null) {
      return 0;
    }

    // 2.本层要做的事
    int res = 0;
    currSum += root.val;

    // 看root到当前节点这条路上是否存在节点前缀和加target等于currSum的路径，也就是起点
    // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
    // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
    res += prefixSumCount.getOrDefault(currSum - target, 0);
    // 更新路径上当前节点前缀和的个数
    prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

    // 3.进入下一层
    res += recursionPathSum(root.left, prefixSumCount, target, currSum);
    res += recursionPathSum(root.right, prefixSumCount, target, currSum);

    // 4.回溯，回到本层恢复状态。
    prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

    return res;
  }

}

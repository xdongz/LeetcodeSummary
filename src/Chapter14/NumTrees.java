package Chapter14;

/**
 * No.96 不同的二叉搜索树
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class NumTrees {

  public static void main(String[] args) {
    System.out.println(numTrees2(4));
  }

  // 方法一：递归。首先1..n的排列便是二叉搜索数的中序遍历，
  // 依次轮取每个数作为该数的root节点。该数左边的数便是左子树的中序遍历结果，
  // 右边便是右子树中序遍历的结果，然后再递归分别求出左右子树可能的结果。

  // 结果一顿操作猛如虎，一看击败百分五
  public static int numTrees(int n) {

    if (n == 1) {
      return 1;
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (i == 0 || i == n-1) {
        ans += numTrees(n-1);
      } else {
        ans += numTrees(i) * numTrees(n-i-1);
      }

    }
    return ans;

  }

  // 其实把方法一改进一下，就变成了方法二。
  // 因为如果节点的个数是一样的，那么它们组成的二叉搜索数的个数也会一样，所以不用重复计算了
  public static int numTrees2(int n) {
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i-1) {
          dp[i] += dp[i-1];
        } else {
          dp[i] += dp[j] * dp[i-j-1];
        }
      }
    }
    return dp[n];
  }
}

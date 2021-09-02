
package Chapter14;

import java.util.HashMap;
import java.util.Map;

/**
 * No. 337 打家劫舍III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 最开始总想着从上到下遍历，后来看了答案发现可以从下往上遍历，然后用两个map分别表示到某个结点时加上和不加上该结点值的最大总和。
 *
 */
public class Rob {

  public static void main(String[] args) {
    //TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)));
    //TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
    TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), null), null);
    System.out.println(rob(root));
  }

  public static int rob(TreeNode root) {

    // 存放着添加该结点时对应的最大值
    Map<TreeNode, Integer> f = new HashMap<>();
    // 存放着不添加该结点时对应的最大值
    Map<TreeNode, Integer> g = new HashMap<>();

    dfs(root, f, g);
    return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
  }

  public static void dfs(TreeNode root, Map<TreeNode, Integer> f, Map<TreeNode, Integer> g) {
    if (root == null) {
      return;
    }

    dfs(root.left, f, g);
    dfs(root.right, f, g);

    f.put(root, g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0) + root.val);
    g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) +
        Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));

  }


//  public static int dfs(TreeNode root, boolean parentFlag, int sum) {
//    if (root == null) {
//      return sum;
//    }
//
//    if (parentFlag) {
//      sum = dfs(root.left, false, sum);
//      sum = dfs(root.right, false, sum);
//    } else {
//      int sum1 = dfs(root.left, true, sum+root.val);
//      sum1 = dfs(root.right, true, sum1);
//      int sum2 = dfs(root.left, false, sum);
//      sum2 = dfs(root.right, false, sum2);
//
//      sum = Math.max(sum1, sum2);
//    }
//    return sum;
//  }

}

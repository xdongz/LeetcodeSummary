
package Chapter14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * No.863 二叉树中所有距离为k的节点
 *
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *。
 */
public class DistanceK {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
    TreeNode target = new TreeNode(6);
    int k = 2;
    System.out.println(distanceK(root, target, k));
  }

  public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    // 1. 首先把所有的节点对应的父节点和子节点存进map中
    Map<Integer, List<Integer>> map = new HashMap<>();
    constructMap(root, map);

    // 2. 寻找target节点的第一层节点，然后深度遍历第一层节点下面的节点，直到到第k层
    // 3. 用visited set存放遍历过的节点以免重复遍历
    Set<Integer> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(target.val);
    visited.add(target.val);
    dfs(map, k, res, 0, path, visited);

    return res;
  }

  public static void constructMap(TreeNode root, Map<Integer, List<Integer>> map) {
    if (root == null) {
      return;
    }

    if (root.left != null) {
      List<Integer> rootList = map.getOrDefault(root.val, new ArrayList<>());
      rootList.add(root.left.val);
      map.put(root.val, rootList);
      List<Integer> leftList = map.getOrDefault(root.left.val, new ArrayList<>());
      leftList.add(root.val);
      map.put(root.left.val, leftList);
    }

    if (root.right != null) {
      List<Integer> rootList = map.getOrDefault(root.val, new ArrayList<>());
      rootList.add(root.right.val);
      map.put(root.val, rootList);
      List<Integer> rightList = map.getOrDefault(root.right.val, new ArrayList<>());
      rightList.add(root.val);
      map.put(root.right.val, rightList);
    }

    constructMap(root.left, map);
    constructMap(root.right, map);
  }

  public static void dfs(Map<Integer, List<Integer>> map, int k, List<Integer> res, int curr, List<Integer> path, Set<Integer> visited) {

    if (curr == k) {
      res.addAll(path);
      return;
    }

    List<Integer> next = new ArrayList<>();
    for (int nodes : path) {
      if (map.get(nodes) != null) {
        for (int node : map.get(nodes)) {
          if (!visited.contains(node)) {
            next.add(node);
            visited.add(node);
          }
        }
      }
    }
    dfs(map, k, res, curr+1, next, visited);
  }

}

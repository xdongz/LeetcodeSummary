
package Chapter14;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * No. 109 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 这道题其实不难，就是找到中间结点，即为根节点，然后再找到分别在根节点的左右链表中找根节点
 *
 */
public class SortedListToBST {

  public static void main(String[] args) {
    ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
    TreeNode root = sortedListBST(head);
    bsf(root);
  }

  public static void bsf(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> res = new ArrayList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      int count = stack.size();
      for (int i = 0; i < count; i++) {
        TreeNode node = stack.pop();
        res.add(node.val);
        if (node.right != null) {
          stack.push(node.right);
        }
        if (node.left != null) {
          stack.push(node.left);
        }

      }
    }
    System.out.println(Arrays.toString(res.toArray()));
  }

  public static TreeNode sortedListBST(ListNode head) {
    return bst(head, null);
  }

  // 设置参数为左右结点，就容易很多
  public static TreeNode bst(ListNode left, ListNode right) {
    // 链表的有效值不应包括right，所以当left == right时结束递归
    if (left == right) {
      return null;
    }
    ListNode mid = findMidNode(left, right);
    TreeNode root = new TreeNode(mid.val);
    root.left = bst(left, mid);
    root.right = bst(mid.next, right);
    return root;
  }

  // 返回的是中间结点
  public static ListNode findMidNode(ListNode left, ListNode right) {

    ListNode slow = left;
    ListNode fast = left;
    while (fast != right && fast.next != right) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int x) { val = x; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

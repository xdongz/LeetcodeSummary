
package Chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * No. 1104 二叉树寻路
 *
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 * 解题思路：很简单，找规律
 */
public class PathInZigZagTree {

  public static void main(String[] args) {
    System.out.println(pathInZigZagTree(1));
  }

  public static List<Integer> pathInZigZagTree(int label) {
    int temp = label;
    int level = 0;
    while (temp != 0) {
      level ++;
      temp = temp / 2;
    }
    List<Integer> ans = new ArrayList<>();
    ans.add(label);
    while (label > 1) {
      // 如果是偶数层
      if (level % 2 == 0) {
        // 如果是偶数层，上一层就是顺序排列
        // 上一层的最小值为：
        int lastMin = (int) Math.pow(2, level-2);
        // 对应的上一层的值为
        int last = (lastMin + (int) (Math.pow(2, level)-1 - label) / 2);
        ans.add(last);
        label = last;
        level--;
      } else {
        // 如果是奇数层，上一层就是倒序排列
        // 上一层的最大值为：
        int lastMax = (int) Math.pow(2, level-1)-1;
        // 对应的上一层的值为
        int last = (lastMax - (int) (label - Math.pow(2, level-1)) / 2);
        ans.add(last);
        label = last;
        level--;
      }
    }
    Collections.reverse(ans);
    return ans;
  }

}

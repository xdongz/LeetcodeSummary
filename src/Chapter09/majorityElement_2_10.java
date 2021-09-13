
package Chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.169
 * 多数元素。给定一个大小为n的数组，找到其中的多数元素，多数元素是指子数组中出现次数大于 n/2 的元素
 */
public class majorityElement_2_10 {

  public static void main(String[] args) {
    int[] nums = {2,1,1,3,1,4,5,6};
    List<Integer> res = new ArrayList<>();
    res = majorityVote2(nums);
    System.out.println(res);
  }

  /**
   * 第一种方法：
   * 把数组排序，如果一个数出现次数大于n/2，那么这个数一定会出现在索引为n/2的位置
   *
   * @param nums 输入的数组
   * @return 返回的元素值
   */
  public int method1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  /**
   * 第二种方法：
   * 摩尔投票算法。原理很简单，但做法有点巧妙
   * 原理是每次从数组中找出一对不同的元素，将它们从数组中删除，直到遍历完整个数组。
   * 做法是：设置两个变量count 和 num，设置count的初始值为0
   * 遍历数组，如果count == 0, 那么把当前值赋给num
   * 如果count != 0, nums[i]与num相等，那么count + 1。如果不相等，那么count - 1.
   * 它是通过count的值加减来表示是否抵消
   * 遍历完之后的num的值就一定是所求的众数 (前提是这个众数一定存在)
   *
   * @param nums 输入的数组
   * @return 返回的元素值
   */
  public int majorityVote(int[] nums) {
    int count = 0, num = 0;

    for (int i : nums) {
      if (count == 0) {
        num = i;
        count ++;
      } else if (i != num) {
        count --;
      } else if (i == num) {
        count ++;
      }
    }
    return num;
  }

  /**
   * 趁热打铁再来一道进阶版的找众数吧！
   * No.229
   * 找出大小为n的数组中，所有出现超过 n/3 次的元素
   * 这道题比上一道要复杂一点，出现超过 n/3 次的元素可能是0个，1个，2个
   * 但原理和上一题差不多，把三个不同的数抵消，最后剩下的数需要再次遍历数组去检验他们是否真的是众数
   * 这次需要设置2个count和2个num
   *
   * @param nums 输入的数组
   * @return 返回的元素值
   */
  public static List<Integer> majorityVote2(int[] nums) {

    int count1 = 0, count2 = 0, num1 = 0, num2 = 0, n = nums.length;

    //if else的顺序很重要
    for (int i : nums) {
      if (i == num1) {
        count1 ++;
      } else if (i == num2) {
        count2 ++;
      } else if (count1 == 0) {
        num1 = i;
        count1 ++;
      } else if (count2 == 0) {
        num2 = i;
        count2 ++;
      } else {
        count1 --;
        count2 --;
      }
    }

    count1 = 0; count2 = 0;
    for (int i : nums) {
      if (i == num1) {
        count1 ++;
      } else if (i == num2) {
        count2 ++;
      }
    }

    List<Integer> res = new ArrayList<>();
    if (count1 > (n / 3)) {
      res.add(num1);
    }

    if (count2 > (n / 3)) {
      res.add(num2);
    }
    return res;

  }
}

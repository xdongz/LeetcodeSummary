
package Chapter05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * No.179 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 本质上是排序，但是要注意的是比如两个数的大小，需要把它们拼接起来，比较拼接后的大小。
 */
public class LargestNumber {

  public static void main(String[] args) {
    int[] nums = {3,30,34,5,9};
    String sb = largestNumber(nums);
    System.out.println(sb);
  }

  public static String largestNumber(int[] nums) {
    List<String> res = new ArrayList<>();
    for (int num : nums) {
      res.add(String.valueOf(num));
    }
    res.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o2+o1).compareTo(o1+o2);
      }
    });
    StringBuilder sb = new StringBuilder();
    for (String s : res) {
      sb.append(s);
    }

    if (sb.charAt(0) == '0') {
      return "0";
    }

    return sb.toString();
  }


}

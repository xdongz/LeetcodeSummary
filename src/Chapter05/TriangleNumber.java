
package Chapter05;

import java.util.Arrays;

/**
 * No.611 有效三角形的个数
 *
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 排序+双指针
 */
public class TriangleNumber {

  public static void main(String[] args) {
    int[] nums = {2,2,4,5};
    System.out.println(triangleNumber(nums));
  }

  public static int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int ans = 0;
    // 第一条边
    for (int i = 0; i < n-2; i++) {
      int k = i;
      for (int j = i+1; j < n-1; j++) {
        while (k+1 < n && nums[i] + nums[j] > nums[k+1]) {
          k++;
        }
        // 比较巧妙的是没有直接用ans++，而是通过k和j的差值计算ans
        ans += Math.max(k-j, 0);
      }

    }
    return ans;
  }

}

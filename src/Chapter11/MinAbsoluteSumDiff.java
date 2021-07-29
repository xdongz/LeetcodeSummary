
package Chapter11;

import java.util.Arrays;

/**
 * No.1818 绝对差值和
 *
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *
 * 解题思路：
 * 遍历0-n，对于每个i，如果被替换成下标j的值，那么与原先的差值和相差：
 * |nums1[i] - nums2[i]| - |nums1[j] - nums2[i]|, 如果这个值的结果越大，那么新的差值和越小
 * 所以nums1[j] 和 nums2[i] 越接近越好
 * 所以对每个i，利用二分法，找到排序后的nums1[i]中第一个大于nums2[i]的元素nums1[j]，
 * 然后比较nums1[j]和nums1[j-1]谁和nums2[i]更接近。
 * 用一个变量maxn存储|nums1[i] - nums2[i]| - |nums1[j] - nums2[i]| 的最大值，
 * 最后用sum-maxn就是结果，注意要取模。
 *
 */
public class MinAbsoluteSumDiff {

  public static void main(String[] args) {
    int[] nums1 = {1,10,4,4,2,7};
    int[] nums2 = {9,3,5,1,7,4};
    System.out.println(minAbsoluteSumDiff(nums1, nums2));
  }

  public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
    int mod = 1000000007;
    int n = nums1.length, maxn = 0, sum = 0;
    int[] rec = new int[n];
    System.arraycopy(nums1, 0, rec, 0, n);
    Arrays.sort(rec);
    for (int i = 0; i < n; i++) {
      int diff = Math.abs(nums1[i] - nums2[i]);
      sum = (sum + diff) % mod;
      //寻找与nums2[i]最接近的nums1[j]
      int j = binarySearch(rec, nums2[i]);
      // rec[j-1]一定小于nums2[i]，所以需要比较rec[j]和rec[j-1]与nums2[i]的差值谁更小。
      if (j < n) {
        maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
      }

      if (j > 0) {
        maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));

      }
    }

    // 每一步sum都取模，最后sum可能会出现比maxn小的情况，所以需要加一个mod
    return (sum - maxn + mod) % mod;
  }

  // 二分法返回的是第一个大于val的下标j，并不是最接近val的数。
  public static int binarySearch(int[] rec, int val) {
    int l = 0, r = rec.length-1;
    if (rec[r] < val) {
      return r + 1;
    }
    while (l < r) {
      int mid = (l + r) / 2;
      if (rec[mid] > val) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

}

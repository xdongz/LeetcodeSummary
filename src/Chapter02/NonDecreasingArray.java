package Chapter02;

/**
 * No. 665 非递减数列
 *
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 这道题不仅仅要比较前后两个元素的大小，还要考虑下例中的特殊情况
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                count++;
                // 如果i==0或者nums[i+1] >= nums[i-1]的贪心策略是改当前值
                if (i > 0 && nums[i+1] < nums[i-1]) {
                    // 这种情况的贪心策略是将后一个值改成与当前值相同
                    nums[i+1] = nums[i];
                }
            }
        }
        return count <= 1;
    }
}

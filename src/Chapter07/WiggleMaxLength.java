package Chapter07;


import java.util.Arrays;

public class WiggleMaxLength {
    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }

    // 方法一：用最长公共子序列的方法求解，复杂度较高
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] temp = new int[n-1];
        for (int i = 1; i < n; i++) {
            temp[i-1] = nums[i] - nums[i-1];
        }
        int max = 0;
        int[] dp = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            if (temp[i] != 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j < i; j++) {
                if (temp[i] * temp[j] < 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max + 1;
    }

    // 方法二：设置两个数组
    //up[i] 表示以前 i 个元素中的某一个为结尾的最长的「上升摆动序列」的长度。
    //down[i] 表示以前 i个元素中的某一个为结尾的最长的「下降摆动序列」的长度。
    public static int method2(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        for (int i = 1; i < n; i++) {
            // 只用比较前一个数字，是因为如果前一个数字是谷底，那么当前数字就可以加入到上升序列中
            // 假设前一个数字不是谷底，那么down数组的最末尾一个元素肯定比前一个数字小，那么当前数字还是可以加入到上升序列中。
            if (nums[i] > nums[i-1]) {
                up[i] = Math.max(up[i-1] , down[i-1] + 1);
                down[i] = down[i-1];
                // 反之亦然
            } else if (nums[i] < nums[i-1]) {
                down[i] = Math.max(down[i-1], up[i-1] + 1);
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1], down[n-1]);
    }
}

package Chapter03;

import java.util.Arrays;

/**
 * No.167 在一个增序的整数数组里找到两个数，使它们的和为给定值。已知有且只有一对解。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l+1, r+1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{0, 0};
    }
}

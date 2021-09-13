package Chapter04;

import java.util.Arrays;

/**
 * No. 34 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums,target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1, mid = 0;
        if (r == -1) {
            return new int[] {-1,-1};
        }
        while (l <= r) {
            mid = (l+r)/2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (nums[mid] == target) {
            int left = mid, right = mid;
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            while (right < nums.length && nums[right] == target) {
                right++;
            }
            return new int[] {left+1, right-1};
        } else {
            return new int[] {-1, -1};
        }
    }
}

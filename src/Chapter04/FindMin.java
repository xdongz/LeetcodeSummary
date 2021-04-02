package Chapter04;

/**
 * No.154 寻找旋转排序数组中的最小值II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 *
 * 和SearchInRotated那题差不多的解题思路
 */
public class FindMin {

    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        while (l < r) {
            mid = (l+r)/2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]){
                r  = mid;
            } else {
                r--;
            }

        }
        return nums[l];
    }
}

package Chapter04;

/**
 * No. 81 搜索旋转排序数组II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返true，否则返回false。
 *
 */
public class SearchInRotated {
    public static void main(String[] args) {
        int[] nums = {2,5,6,2,2,2,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1, mid;
        while (l <= r) {
            mid = (l+r)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[r]) {
                // 说明右区间是排好序的,如果target刚好在这个区间内，那么就对这个区间进行二分查找
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > nums[r]){
                // 说明左区间是排好序的,如果target刚好在这个区间内，那么就对这个区间进行二分查找
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 如果nums[mid] == nums[r]，不能判断是左区间值全相等，还是右区间值全相等，那么就把r减一继续比较
                r--;
            }
        }
        return false;
    }
}

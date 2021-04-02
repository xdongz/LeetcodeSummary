package Chapter04;

/**
 * No.540 有序数组中的单一元素
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 既然是有序数组，那么就可以不用位与等方式了，因为那样的复杂度位O(n)
 * 如果是有序数组，那么该独立数一定在偶数索引上。所以可以只对偶数索引进行二分搜索。
 */
public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1, mid;
        while (l < r) {
            mid = (l+r)/2;
            if (mid % 2 == 1) {
                mid --;
            }
            if (nums[mid] == nums[mid+1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}

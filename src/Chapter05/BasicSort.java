
package Chapter05;

import java.util.Arrays;

public class BasicSort {

  public static void main(String[] args) {
    int[] nums = {4,5,6,3,1,2};
    insertSort(nums);
    System.out.println(Arrays.toString(nums));
  }

  // 稳定指的是，如果两个元素的值相同，经过排序之后，会不会改变他们的先后顺序

  //------------------------------简单排序-------------------------------------
  /**
   * 1. 冒泡排序 (稳定)
   * 每次比较相邻的两个数，如果后一个数比前一个数小，则交换位置
   * 那么一次遍历之后，就把最大的那个数固定下来了
   *
   * 时间复杂度： O(n*n)
   */
  public static void bubbleSort(int[] nums) {
    int n = nums.length;
    // 一共需要遍历n-1次才能固定下所有的数
    for (int i = n-1; i > 0 ; i--) {
      // 每次遍历需要比较从0-i之间的数
      for (int j = 0; j < i; j++) {
        if (nums[j+1] < nums[j]) {
          swap(nums, j, j + 1);
        }
      }
    }
  }

  /**
   * 2. 选择排序 （不稳定）
   * 每次遍历从从未固定的元素中找出值最小的那个元素
   * 然后与需要固定的元素交换位置
   *
   * 时间复杂度： O(n*n)
   *
   */
  public static void selectionSort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n-1; i++) {
      // 索引i表示需要固定的元素的位置，每次遍历就固定一个元素
      int minIndex = i;
      // 找出从i-n中最小值的索引
      for (int j = i; j < n; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }
      // 与需要固定的位置i交换元素
      swap(nums, i, minIndex);
    }
  }

  /**
   * 3. 插入排序（稳定）
   *
   * 插入排序会把数组元素分为已排序和未排序两组
   * 每次找到未排序组中的第一个元素，向已排序的组中进行插入
   *
   * 时间复杂度： O(n*n)
   */
  public static void insertSort(int[] nums) {
    int n = nums.length;

    // 初始时，假定第一个元素是已排序组的，其余元素是未排序组的
    for (int i = 1; i < n; i++) {
      // 从i-0，一个一个地比较，如果前一个数字比当前数字大，就交换位置
      for (int j = i; j > 0 && nums[j] < nums[j-1]; j--) {
        swap(nums, j, j-1);
      }
    }
  }


  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}

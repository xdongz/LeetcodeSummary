package Chapter04;

/**
 * No.852 山脉数组的峰顶索引
 *
 * 其实就是找到最小的索引，使得arr[i]>arr[i+1]
 *
 * 最常规的就是一次遍历，但是为了减少时间复杂度，可以用二分法
 */
public class PeekIndexInMountainArray {

  public static void main(String[] args) {
    int[] arr = {24,69,100,99,79,78,67,36,26,19};
    System.out.println(peakIndexInMountainArray(arr));
  }

  public static int peakIndexInMountainArray(int[] arr) {
    int n = arr.length, left = 0, right = n-1;
    while (left < right) {
      int mid = (left+right)/2;
      if (arr[mid] > arr[mid+1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

}

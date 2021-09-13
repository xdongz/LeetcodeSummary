package Chapter05;

public class SmallestK {

  public static int[] smallestK(int[] arr, int k) {
    int n = arr.length;
    int lo = 0, hi = n -1;
    int[] res = new int[k];

    while (lo < hi) {
      int partition = partition(arr, lo, hi);
      if (partition == k) {
        System.arraycopy(arr, 0, res, 0, k);
        return res;
      } else if (partition < k) {
        lo = partition + 1;
      } else {
        hi = partition - 1;
      }
    }
    System.arraycopy(arr, 0, res, 0, k);
    return res;
  }

  public static int partition(int[] arr, int lo, int hi) {
    int pivot  = arr[lo];
    int l = lo, r = hi+1;

    while (l < r) {
      while (l < r && arr[--r] > pivot) {
        continue;
      }
      while (l < r && arr[++l] < pivot) {
        continue;
      }
      swap(arr, l, r);
    }
    swap(arr, l, lo);
    return l;
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

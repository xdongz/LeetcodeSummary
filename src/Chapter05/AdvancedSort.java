
package Chapter05;

import java.util.Arrays;

public class AdvancedSort {

  public static void main(String[] args) {
    int[] nums = {3,2,3,1,2,4,5,5,6};
    heapSort(nums);
    System.out.println(Arrays.toString(nums));
  }

  //------------------------------高级排序-------------------------------------
  // 简单排序的时间复杂度都是O(n*n)，高级排序是对简单排序的优化

  /**
   * 1. 希尔排序（不稳定）
   * 选定一个增长量h，按照h作为数据分组的依据，对数据进行分组
   * 对分好组的每一组数据完成插入排序
   * 减少增长量，最小减为1，重复第二步操作
   */
  public static void shellSort(int[] nums) {
    int n = nums.length;

    // 1）. 根据数组的长度，确定增长量h的初始值
    int h = 1;
    while (h < n/2) {
      h = 2*h + 1;
    }

    // 2）. 希尔排序
    while (h >= 1) {
      // 排序
      // 2.1 找到待插入的元素 nums[i]
      for (int i = h; i < n; i++) {
        // 2.2 把待插入的元素插入到有序组中（这个地方和insertSort一样）
        for (int j = i; j >= h && nums[j] < nums[j-h]; j=j-h) {
          swap(nums, j, j-h);
        }
      }

      // 3）.减小h的值
      h = h/2;
    }
  }

  /**
   * 2. 归并排序（稳定）
   * 它是分治思想最典型的例子，对nums[lo..hi]排序，首先将它分为nums[lo..mid] 和 nums[mid+1..hi]
   * 分别通过递归将他们单独排序，然后将两个有序数组归并为一个有序数组
   *
   * 一共分为logn层，每层需要比较的次数是n次
   * 时间复杂度：O(nlogn)
   */
  public static void mergeSort(int[] nums) {
    int n = nums.length;
    int[] assist = new int[n];
    mergeSort(nums, 0, n-1, assist);
  }

  // 从索引lo到hi的元素的排序
  public static void mergeSort(int[] nums, int lo, int hi, int[] assist) {
    if (hi <= lo) {
      return;
    }

    // 将lo到hi之间的元素分为两个组
    int mid = lo + (hi - lo) / 2;

    // 分别对每一组数据进行排序
    mergeSort(nums, lo, mid, assist);
    mergeSort(nums, mid+1, hi, assist);

    // 再把两个组的数据进行归并
    merge(nums, lo, mid, hi, assist);
  }

  // lo到mid为一组，mid+1到hi为一组，把这两组数据进行归并
  public static void merge(int[] nums, int lo, int mid, int hi, int[] assist) {
    // 定义三个指针
    int p = lo, q = mid+1, l = lo;
    // 遍历，移动p指针和q指针，比较对应索引的值，找出小的那个，移到辅助数组中
    while (p <= mid && q <= hi) {
      if (nums[p] <= nums[q]) {
        assist[l++] = nums[p++];
      } else {
        assist[l++] = nums[q++];
      }
    }

    // 遍历，如果p指针没有走完，那么顺序移动p指针，把对应的元素放到辅助数组对应的索引处
    while (p <= mid) {
      assist[l++] = nums[p++];
    }

    // 遍历，如果q指针没有走完，那么顺序移动q指针，把对应的元素放到辅助数组对应的索引处
    while (q <= hi) {
      assist[l++] = nums[q++];
    }
    // 把辅助数组中的元素拷贝到原数组中
    for (int i = lo; i <= hi; i++) {
      nums[i] = assist[i];
    }
  }

  /**
   * 3. 快速排序（不稳定)
   * 也是分治思想的体现
   *
   * 最优情况下，时间复杂度为O(nlogn)
   * 最坏情况下，时间复杂度为O(n*n)
   * 平均情况下的时间复杂度为O(nlogn)
   */
  public static void quickSort(int[] nums) {
    quickSort(nums, 0, nums.length-1);
  }

  // 从索引lo到hi的元素的排序
  private static void quickSort(int[] nums, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    // 将lo到hi之间的元素分为两个组 (左子组和右子组)
    int partition = partition(nums, lo, hi); // 返回的是分组的分界值的索引

    // 让左子组有序
    quickSort(nums, lo, partition-1);

    // 让右子组有序
    quickSort(nums, partition+1, hi);


  }
  
  private static int partition(int[] nums, int lo, int hi){
    // 设定基准值
    int pivot = nums[lo];

    // 设定两个指针，先移动r，再移动l，这样可使得重合的时候，所指向的值是小于pivot的
    int l = lo, r = hi + 1;

    // l指针向右走，找到第一个比基准值大的数，r指针向左走，找到第一个比基准值小的数，交换这两个数，直到退出循环
    while (l < r) {
      // 首先从右向左扫描，找到一个比分界值小的元素，停止
      while (l < r && pivot < nums[--r]) {
        continue;
      }
      // 首先从左向右扫描，找到一个比分界值小的元素，停止
      while (l < r && pivot > nums[++l]) {
        continue;
      }
      // 交换左右指针的值
      swap(nums, l, r);

    }

    // 交换分界值
    swap(nums, lo, l);
    // 返回分界值的索引
    return l;
  }

  /**
   * 4. 堆排序
   *
   * 堆的特性：完全二叉树。除了树的最后一层结点不需要是满的，其他的每一层从左到右都是满的，如果最后一层结点不是满的，那么要求左满右不满
   * 它通常用数组来实现。从下标为1的位置开始存储数据
   * 如果一个结点的位置是k，那么它的父节点的位置为k/2，它的两个子节点的位置分别为2k和2k+1，父节点的值比两个子节点的值要大，但左右两个子节点的大小没有规定
   *
   */
  public static void heapSort(int[] nums) {
    int[] heap = new int[nums.length+1];
    // 构建堆
    createHeap(nums, heap);
    // 定义一个变量N，记录未排序的元素中最大的索引
    int N = heap.length - 1;
    while (N != 1) {
      // 交换最大索引处的元素和索引1处的元素 （索引1处的元素永远是未排序中的最大值）
      swap(heap, 1, N);
      // 排序交换后的最大元素所在的索引不需要参与下沉处理，因为位置已经固定了
      N--;
      sink(heap, 1, N);
    }
    // 把heap中的数据复制到原数组source中
    System.arraycopy(heap, 1, nums, 0 ,nums.length);

  }

  // 1) 根据原数组构造出堆heap
  private static void createHeap(int[] nums, int[] heap) {
    int n = nums.length;
    // 将原数组中的元素拷贝到heap中，heap中的元素就形成了一个堆，但是是一个无序堆
    System.arraycopy(nums, 0, heap, 1, n);

    // 对堆中的元素做下沉调整，从长度一半开始，往索引1处扫描，因为长度一半之后的结点都是叶子结点
    for (int i = n/2; i >=1 ; i--) {
      sink(heap, i, heap.length-1);
    }
  }

  // 上浮算法，使索引k处的元素能在堆中处于一个正确的位置
  private static void swim(int[] nums, int k) {
    while (k > 1) {
      // 比较当前结点和父节点的值，如果父节点比当前结点的值小，那么交换这两个结点的值
      int parentId = k / 2;
      if (nums[parentId] < nums[k]) {
        swap(nums, parentId, k);
      }
      k  = k / 2;
    }
  }

  // 下沉算法
  private static void sink(int[] heap, int k, int range) {
    // 通过循环，不断对比当前结点和其左子节点2*k和右子节点2*k+1中较大值元素的大小，如果当前结点小，则交换位置
    while (2*k <= range) {
      // 获取当前结点子结点的较大结点
      int max = 2*k;
      if (2*k+1 <= range) {
        if (heap[2*k] < heap[2*k+1]) {
          max = 2*k+1;
        }
      }

      // 比较当前结点和较大结点的值
      if (heap[k] < heap[max]) {
        swap(heap, k , max);
      } else {
        break;
      }
      // 变换k的值
      k = max;
    }
  }


  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}

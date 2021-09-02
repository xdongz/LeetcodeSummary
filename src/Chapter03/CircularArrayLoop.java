
package Chapter03;

/**
 * No. 457 环形数组是否存在循环
 *
 * 循环题目一般首先考虑到快慢指针。这道题还有一个难点在于如果保证环形的同方向性。
 */
public class CircularArrayLoop {

  public static void main(String[] args) {
    int[] nums = {1,1,1,1,1,1,1,1,1,-5};
    System.out.println(circularArrayLoop(nums));
  }

  public static boolean circularArrayLoop(int[] nums) {
    int n = nums.length;
    int fast, slow;
    // 1. 假设某个结点为环形起点，那么快慢指针从该处出发
    for (int i = 0; i < n; i++) {
      // 如果该结点已经遍历过就直接看下一个结点
      if (nums[i] == 0) {
        continue;
      }

      fast = next(nums, next(nums, i));
      slow = next(nums, i);

      // 2. 如果快慢指针在移动的过程中方向不同，那么直接break
      // 因为环形内方向要一致
      // 不仅要fast和slow的方向一致，还要保证slow和next(fast)方向一致，因为fast每次跳2下
      while (nums[fast] * nums[slow] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
        // 3. 如果快慢指针相遇了，且不是单数循环就返回true
        if (fast == slow) {
          if (slow != next(nums, slow)) {
            return true;
          } else {
            break;
          }
        }
        slow = next(nums, slow);
        fast = next(nums, next(nums, fast));
      }

      // 优化：如果到这一步，说明该结点和快慢指针所经过的结点不在环内
      int add = i;
      while (nums[add] * nums[next(nums, add)] > 0) {
        int tmp = add;
        add = next(nums, add);
        nums[tmp] = 0;
      }
    }
    return false;
  }

  // 返回下一个的位置
  public static int next(int[] nums, int cur) {
    int pos = nums[cur] + cur;
    int n = nums.length;
    return ((pos % n) + n) % n;
  }

}

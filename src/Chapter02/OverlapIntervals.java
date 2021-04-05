package Chapter02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No.435 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 */
public class OverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        // 优先保留结尾数字小的元素，所以只需要对结尾的数字排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int res = 0, prevIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (isOverlap(intervals[i], intervals[prevIndex])) {
                res++;
            } else {
                prevIndex = i;
            }
        }
        return res;
    }

    public static boolean isOverlap(int[] num1, int[] num2) {
        return num2[0] < num1[1] && num1[0] < num2[1];
    }
}

package Chapter02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No. 452 用最少数量的箭引爆气球
 *
 * 注意与OverlapIntervals这道题的区别
 */
public class MinArrowShots {

    public static void main(String[] args) {
        int[][] points = {{9,12}, {1,10},{4,11},{8,12}, {3,9}, {6,9}, {6,7}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int count = 1;
        int[] preIndex = new int[]{points[0][0], points[0][1]};
        // 如果重叠，那么将preIndex更新为两者相交的部分，否则，直接将preIndex更新为points[i]
        for (int i = 1; i < points.length; i++) {
           if (!isOverlap(points[i], preIndex)) {
               count++;
               preIndex = points[i];
           } else {
               preIndex[0] = Math.max(points[i][0], preIndex[0]);
               preIndex[1] = Math.min(points[i][1], preIndex[1]);
           }
        }
        return count;
    }

    public static boolean isOverlap(int[] nums1, int[] nums2) {
        return nums2[0] <= nums1[1] && nums1[0] <= nums2[1];
    }
}

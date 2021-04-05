package Chapter02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No.406 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 */
public class ReconstructQueue {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1]-o1[1] : o1[0] - o2[0];
            }
        });

        // 先排好身高最矮的
        int[][] ans = new int[people.length][];
        for (int[] person:people) {
            // 用space变量来确定当前元素的位置，从0开始，数第space个空位，就能填入该元素
            int space = person[1]+1;
            for (int i=0; i<people.length; i++) {
                if (ans[i] == null) {
                    space--;
                }
                if (space==0) {
                    ans[i] = person;
                    break;
                }
            }
        }
        return ans;
    }
}

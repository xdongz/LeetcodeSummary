package Chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * No.763 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * 在处理数组前，统计一遍信息（如频率、个数、第一次出现位置、最后一次出现位置等）可以使题目难度大幅降低。
 *
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] end = new int[26];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int id = ch - 'a';
            end[id] = i;
        }
        int prev = -1;
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            int size = end[curr - 'a'];
            for (int j = i+1; j <= size; j++) {
                if (end[S.charAt(j) - 'a'] > size) {
                    size = end[S.charAt(j) - 'a'];
                }
            }
            i = size;
            ans.add(size - prev);
            prev = size;
        }
        return ans;
    }
}

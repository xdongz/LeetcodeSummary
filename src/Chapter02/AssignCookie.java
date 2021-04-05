package Chapter02;

import java.util.Arrays;

/**
 * No.455 分配糖果
 *
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 一个饼干，且只有饼干的大小不小于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩子可以吃饱
 *
 * 解题思路：优先分给饥饿度最小的孩子
 */
public class AssignCookie {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l  = 0, r = 0, res = 0;
        while (l < g.length && r < s.length) {
            if (s[r] >= g[l]) {
                res++;
                l++;
            }
            r++;
        }
       return res;
    }
}

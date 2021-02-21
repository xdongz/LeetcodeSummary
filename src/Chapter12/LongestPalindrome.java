package Chapter12;

import java.util.*;

/**
 * No.409 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 解题思路： 如果一个字符出现了偶数次，那么它们全部都可以加入到回文串中，
 * 如果一个字符出现了奇数次，那么次数-1可以加入到回文串中
 * 但如果有字符是出现了奇数次，那么总的长度可以再加1. 但只能加一次
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
    //第一种方法是用map
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean oddFlag = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        Set<Character> keys = map.keySet();
        for (char key : keys) {
           int value = map.get(key);
           if (value % 2 == 0) {
              count += value;
           } else {
               count += value - 1;
               oddFlag = true;
           }
        }
        return oddFlag ? count + 1 : count;
    }

    //第二种方法用固定长度的数组，效率更高
    public static int method2(String s) {
        int[] table = new int[128];
        Arrays.fill(table, 0);
        for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           table[ch]++;
        }

        int ans = 0;
        for (int t : table) {
            ans += t / 2 * 2;
            //如果有字符出现的是奇数次，那么ans可以加1，但是只能加1次
            //如果没有出现过那么根据51行，ans一定是偶数，如果加过一次，那么ans一定是奇数，就不会再进入这个if语句里了
            if (t % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


}

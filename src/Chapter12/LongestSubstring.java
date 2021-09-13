package Chapter12;

import java.util.HashSet;
import java.util.Set;

/**
 * No.3 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 方法一： 遍历s，用set存储所遍历到的字符串，遇到重复的字符串就回溯，并清空set
 *
 * 方法二：滑动窗口，设置两个指针left和right分别表示不重复字符串的左端和右端
 * 刚开始left=right，right一直右移，直到set中有重复的字符。然后计算长度：right - left
 * left每次右移，set就remove之前的那个元素
 * 注意：遇到重复的字符时，right不必重置。
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(method2(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0, count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                count ++;
            } else {
                max = Math.max(max, count);
                count = 0;
                set.clear();
                //回溯
                while (i >= 0) {
                   i--;
                   if (s.charAt(i) == ch) {
                       break;
                   }
                }
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static int method2(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
           if (i != 0) {
               set.remove(s.charAt(i-1));
           }
           while (right < s.length() && !set.contains(s.charAt(right))) {
               set.add(s.charAt(right));
               right ++;
           }
           int count = right - i;
           max = Math.max(max, count);
        }
        return max;
    }
}

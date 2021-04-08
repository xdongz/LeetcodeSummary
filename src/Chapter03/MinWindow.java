package Chapter03;

/**
 * No.最小覆盖子串
 *
 * 给定两个字符串 S 和 T，求 S 中包含 T 所有字符的最短连续子字符串的长度，同时要求时间
 * 复杂度不得超过 O(n)。
 *
 * 用滑动窗口解决此题
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        boolean[] flag = new boolean[128];
        int[] countT = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            flag[ch - 'A'] = true;
            countT[ch - 'A']++;
        }
        int l = 0, count = 0, minL = 0, minSize = s.length() + 1;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (flag[ch - 'A']) {
                if (--countT[ch - 'A'] >= 0) {
                    count++;
                }

                // 如果l和r区间包含了t中所有的字符
                // l开始右移
                while (count == t.length()) {
                    if (r - l + 1 < minSize) {
                        minSize = r -l + 1;
                        minL = l;
                    }
                    // ++countT[s.charAt(l) - 'A'] > 0 代表l-r区间没有多余的重复字符s.charAt(l)了
                    if (flag[s.charAt(l) - 'A'] && ++countT[s.charAt(l) - 'A'] > 0) {
                        --count;
                    }
                    l++;
                }
            }
        }
        return minSize > s.length() ? "" : s.substring(minL, minL + minSize);
    }
}

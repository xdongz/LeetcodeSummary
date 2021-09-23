package Chapter03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * No.524 通过删除字母匹配到字典里最长的单词
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 */
public class FindLongestWord {

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        System.out.println(findLongestWord(s, d));

    }
    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length()-o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        System.out.println(d);
        for (String t : d) {
            if (isSubsequence(s, t)) {
                return t;
            }
        }
        return "";
    }

    public static boolean isSubsequence(String s, String t) {
        int l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                r++;
            }
            l++;
        }
        return r == t.length();
    }
}

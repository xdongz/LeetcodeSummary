package Chapter12;

/**
 * No.28
 *
 * 判断一个字符串是不是另一个字符串的子字符串，并返回其位置。
 *
 */
public class ImplementStr {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issipi";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 利用substring来判断needle是否是haystack的子串
     * 时间复杂度O((m-n)*n)
     */
    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int start = 0; start < m - n + 1; start++) {
            if (haystack.substring(start, start + n).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 方法二： 只需要在haystack[i] == needle[0]的时候比较，如果在比较的过程中不相等，再回溯
     */
    public int method2(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) return 0;
        if (m == 0 || m < n) return -1;

        char start = needle.charAt(0);
        for (int i = 0; i < m - n + 1; i++) {
            if (haystack.charAt(i) == start){
                int p = i + 1;
                int j = 1;
                while (p < m && j < n && haystack.charAt(p) == needle.charAt(j)) {
                    p++;
                    j++;
                }
                if (j == n){
                    return i;
                }
            }
        }
        return -1;
    }
}

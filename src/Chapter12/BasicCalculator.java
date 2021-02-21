package Chapter12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No. 227 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 解题思路：如果是加号就直接push入栈，如果前面是减号，就push -num， 如果遇到了乘法，就把栈顶的元素pop出来乘以当前数字再入栈
 * 除法同乘法。 最后把栈中元素相加即可
 * 题目不难，就是加入了空格，需要考虑到各种细节
 */
public class BasicCalculator {
    public static void main(String[] args) {
        String s = "3 +   5 * 5 / 2";
        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        boolean subFlag = false, multiFalg = false, disFlag = false;

        int ptr = 0;
        while (ptr < n) {
            while (ptr < n && s.charAt(ptr) == ' ') {
                ptr++;
            }
            if (ptr < n && s.charAt(ptr) >= '0' && s.charAt(ptr) <= '9') {
            int num = 0;
            while (ptr < n && s.charAt(ptr) >= '0' && s.charAt(ptr) <= '9') {
                num = num *10 + s.charAt(ptr) - '0';
                ptr++;
            }
            if (subFlag) {
                stack.push(-num);
                subFlag = false;
            } else if (multiFalg) {
                int prev = stack.pop();
                stack.push(prev * num);
                multiFalg = false;
            } else if (disFlag) {
                int prev = stack.pop();
                stack.push(prev/num);
                disFlag = false;
            } else {
                stack.push(num);
            }} else if (ptr < n){
                if (s.charAt(ptr) == '-') {
                    subFlag = true;
                    ptr++;
                } else if (s.charAt(ptr) == '*') {
                    multiFalg = true;
                    ptr++;
                } else if (s.charAt(ptr) == '/') {
                    disFlag = true;
                    ptr++;
                } else if (s.charAt(ptr) == '+') {
                    ptr++;
                }
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}

package Chapter02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * No.781 森林中的兔子
 *
 * 贪心
 */
public class NumRabbits {
    public static void main(String[] args) {
        int[] answers = {1,2,2,2,2,3};
        System.out.println(numRabbits(answers));
    }
    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            int value = map.get(key);
            int m = value / (key+1);
            int n = value % (key+1);
            res += n == 0 ? m*(key + 1) : (m+1)*(key + 1);
        }
        return res;
    }
}

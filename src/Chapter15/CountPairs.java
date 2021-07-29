
package Chapter15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * No.1711 大餐计数
 */
public class CountPairs {

  public static void main(String[] args) {
    int[] deliciousness = {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,
        1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
    System.out.println(method2(deliciousness));
  }

  // 方法一超时
  public static int countPairs(int[] deliciousness) {
    final int MOD = 1000000007;
    Map<Integer, Integer> map = new HashMap<>();
    for (int deli : deliciousness) {
      map.put(deli, map.getOrDefault(deli, 0)+1);
    }
    Set<Integer> set = map.keySet();
    List<Integer> list = new ArrayList<>(set);
    int count = 0;
    for (int i = 0; i < list.size(); i++) {
      if (map.get(list.get(i)) > 1 && isTwoPow(list.get(i) + list.get(i))) {
        int n = map.get(list.get(i));
        count = (count+n*(n-1)/2) % MOD;
      }
      for (int j = i+1; j < list.size(); j++) {
        if (isTwoPow(list.get(i) + list.get(j))) {
          int m = map.get(list.get(i));
          int n = map.get(list.get(j));
          count = (count + m*n) % MOD;
        }
      }
    }

    return count;

  }

  public static boolean isTwoPow(int x) {
    return (x & (x-1)) == 0 && x != 0;
  }

  public static int method2(int[] deliciousness) {
    final int MOD = 1000000007;
    Map<Integer, Integer> map = new HashMap<>();
    int maxVal = 0;
    for (int deli : deliciousness) {
      maxVal = Math.max(maxVal, deli);
    }

    int pairs = 0;
    for (int val : deliciousness) {
      for (int sum = 1; sum <= maxVal * 2; sum <<= 1) {
        int count = map.getOrDefault(sum - val, 0);
        pairs = (pairs + count) % MOD;
      }
      map.put(val, map.getOrDefault(val, 0) + 1);
    }
    return pairs;
  }

}

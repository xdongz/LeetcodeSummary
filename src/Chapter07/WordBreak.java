
package Chapter07;

import java.util.Arrays;
import java.util.List;

/**
 * No.139 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 此题和PerfectSquares的方法类似
 * 在考虑每个分割位置时，需要遍历字符串集合，以确定当前位置是否可以成功分割。注意对于位置0，需要初始化值为真。
 */
public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n+1];

    Arrays.fill(dp ,false);
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      for (String word : wordDict) {
        int len = word.length();
        if (i >= len && s.substring(i - len, i).equals(word)) {
          dp[i] = dp[i] || dp[i - len];
        }
      }
    }
    return dp[n];
  }

}

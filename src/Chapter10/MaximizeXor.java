package Chapter10;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No.1707 与数组中元素的最大异或值
 *
 * 一看这道题是困难题，就知道不简单，果然暴力法超时了
 * 看了题解才知道可以用前缀树。
 */
public class MaximizeXor {
    public static void main(String[] args) {
        int[] nums = {5,2,4,6,6,3};
        int[][] queries = {{12,4}, {8,1}, {6,3}};
        int[] ans = maximizeXor(nums, queries);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        // 这个很重要，保证queries排序后，仍能按原先的索引存入ans中。
        int[][] newQueries = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
           newQueries[i][0] = queries[i][0];
           newQueries[i][1] = queries[i][1];
           newQueries[i][2] = i;
        }
        Arrays.sort(newQueries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] ans = new int[queries.length];
        TrieTree trie = new TrieTree();
        int idx = 0;
        for (int[] query : newQueries) {
            int x = query[0], m = query[1], index = query[2];
            while (idx < nums.length && nums[idx] <= m) {
                trie.insert(nums[idx]);
                idx++;
            }
            if (idx == 0) {
                ans[index] = -1;
            } else {
                ans[index] = trie.getMaxInt(x);
            }
        }
        return ans;
    }

    static class TrieTree {
        int L = 30;
        TrieTree[] children = new TrieTree[2];

        // 向前缀树中插入某个数
        public void insert(int val) {
            TrieTree node = this;
            // 前缀树要从高位到低位排列，因为要尽量保证高位不同，这样异或值才会更大
            for (int i = L-1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieTree();
                }
                node = node.children[bit];
            }
        }

        // 获得前缀树中异或最大值
        public int getMaxInt(int val) {
            int ans = 0;
            TrieTree node = this;
            for (int i = L-1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (node.children[bit ^ 1] != null) {
                    ans = ans | (1 << i);
                    node = node.children[bit ^ 1];
                } else {
                    node = node.children[bit];
                }
            }
            return ans;
        }

    }

}

package Chapter02;

import java.util.Arrays;

/**
 * No.135 糖果
 *
 * 一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，规则是如果一
 * 个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果；所
 * 有孩子至少要有一个糖果。求解最少需要多少个糖果。
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,3,4,5,2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // 先从左向右遍历一遍
        for (int i = 1; i < n; i++) {
           if (ratings[i] > ratings[i-1]) {
               candies[i] = candies[i-1] + 1;
           }
        }
        // 从右向左遍历一遍
        for (int i = n-2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }

        // 统计candies数组中一共多少颗糖
        int res = 0;
        for (int can : candies) {
            res += can;
        }
        return res;
    }
}

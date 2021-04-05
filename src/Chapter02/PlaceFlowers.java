package Chapter02;

/**
 * No. 605 种花问题
 *
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 *
 */
public class PlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int k = flowerbed.length, count = 0;

        // 注意考虑特殊情况
        if (k == 1) {
            if (flowerbed[0] == 1) {
                return n == 0;
            } else {
                return true;
            }
        }
        for (int i = 0; i < k; i++) {
            if ((i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) || (i == k-1 && flowerbed[i-1] == 0) && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                count ++;
            } else if (i >= 1 && i < k-1) {
                if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }
}

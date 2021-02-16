/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter11;

import java.util.HashMap;
import java.util.Map;

/**
 * No.149 直线上最多的点数
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 */
public class MaxPoints {

  public static void main(String[] args) {

    int[][] points = {{0,0},{0,1}};
    //int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
    //int[][] points = {{1,1},{2,2},{3,3}};
    //int[][] points = {{2,3},{3,3},{-5,3}};
    System.out.println(maxPoints(points));
  }

  public static int maxPoints(int[][] points) {
    //key是斜率，value是点的个数
    Map<String, Integer> map = new HashMap<>();
    int max = 0;

    for (int i = 0; i < points.length; i++) {
      int same = 1, maxCount = 0;
      for (int j = i + 1; j < points.length; j++) {
        //注意点一： 找出相同的点。如果有多个相同的点，那么经过它的直线上的点也应包含这些相同点的个数
        if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
          same ++;
        } else {
          //注意点二：求斜率用String表示，用double的话会有精度的问题，而且还需要考虑dx = 0 的情况
          //先求出分子分母的最大公约数，然后除以最大公约数，并组合成String
          int dx = points[j][0] - points[i][0], dy = points[j][1] - points[i][1];
          String slope = buildSlope(dx, dy);
          map.put(slope, map.getOrDefault(slope, 0) + 1);
          maxCount = Math.max(maxCount,map.get(slope));
        }
      }
      //map中对应的点的个数应该加上相同点的个数
      max = Math.max(max,  maxCount + same);
      //注意点三： 每次要清空map，为了避免重复计算
      map.clear();
    }
    return max;
  }

  private static String buildSlope(int p, int q) {
    int gcd = computeGcd(p, q);
    return p / gcd + "_" + q / gcd;
  }

  private static int computeGcd(int p, int q) {
    if (q == 0) return p;
    int r = p % q;
    return computeGcd(q, r);
  }

}

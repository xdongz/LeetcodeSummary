package Chapter08;

import java.util.ArrayList;
import java.util.List;

/**
 * No.401 二进制手表
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 这道题首先想到的是回溯。。。。
 * 但是简单题肯定有更简单的方式，其实就是要找时针和分针位数之和为turnedOn的可能性
 * 那么可以用枚举
 */
public class ReadBinaryWatch {

  public static List<String> readBinaryWatch(int turnedOn) {
    List<String> res = new ArrayList<>();

    for (int h = 0; h < 12; h++) {
      for (int m = 0; m < 60; m++) {
        if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
          res.add(h + ":" + (m < 10 ? "0" : "") + m);
        }
      }
    }
    return res;
  }

}

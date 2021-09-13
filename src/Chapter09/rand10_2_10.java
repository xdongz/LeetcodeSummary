
package Chapter09;

/**
 * No.470
 * 用Rand7()实现Rand10()
 */
public class rand10_2_10 {

  /**
   * 有一个公式：(randX() - 1) * Y + randY()会生成[1, X*Y]中的均匀随机数
   * 还有一个公式： 如果X是Y的倍数，那么randX() % Y + 1会均匀产生[1, Y]的随机数
   *
   * @return
   */
  public int rand10() {
    while (true) {
      int x = (rand7() - 1) * 7 + rand7(); //会生成1-49中的均匀随机数
      if (x <= 40) {
        return x % 10 +1;
      }
    }
  }

  //A fake function
  public int rand7() {
    return 0;
  }
}

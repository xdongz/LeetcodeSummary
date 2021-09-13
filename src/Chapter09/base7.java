
package Chapter09;

//十进制转七进制
//*这道题很基础，所以一定要掌握*
public class base7 {

  public static void main(String[] args) {
    System.out.println(convertToBase7(100));
  }

  //按照从右往左计算
  //最右一位的结果为 num % 7
  //那么倒数第二位的值便为 (num / 7) % 7
  //以此类推
  //本题还可以扩展到二进制八进制等等
  //最后要注意边界条件, num = 0 和 num < 0
  public static String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }

    boolean isNegative = false;
    if (num < 0) {
      isNegative = true;
      num = - num;
    }

    String str = "";
    while (num > 0) {
      int a  = num / 7, b = num % 7;
      str = b + str;
      num = a;
    }
    return isNegative ? "-" + str : str;
  }
}

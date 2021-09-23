package Chapter11;

/**
 * No.有效的数独
 *
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 */
public class IsValidSudoku {

  public static boolean isValidSudoku(char[][] board) {
    int[][] row = new int[9][9];
    int[][] column = new int[9][9];
    int[][][] block = new int[3][3][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char ch = board[i][j];
        if (ch != '.') {
          int num = ch - '1';
          row[i][num]++;
          column[j][num]++;
          block[i / 3][j / 3][num]++;
          if (row[i][num] > 1 || column[j][num] > 1 || block[i / 3][j / 3][num] > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }
}

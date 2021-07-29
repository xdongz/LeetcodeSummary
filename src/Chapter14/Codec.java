
package Chapter14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
    System.out.println(serialize(root));
  }

  public static String serialize(TreeNode root) {
    String ans = "";
    return rserialize(root, ans);
  }

  public static TreeNode deserialize(String data) {
    String[] dataArray = data.split(",");
    List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
    return rdeserialize(dataList);

  }

  public static String rserialize(TreeNode root, String str) {
    if (root == null) {
      str += "None,";
      return str;
    }

    str += root.val + ",";
    str = rserialize(root.left, str);
    str = rserialize(root.right, str);
    return str;
  }

  public static TreeNode rdeserialize(List<String> data) {
    if (data.get(0).equals("None")) {
      data.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
    data.remove(0);
    root.left = rdeserialize(data);
    root.right = rdeserialize(data);
    return root;
  }

}

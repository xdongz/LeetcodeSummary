
package Chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * No.1418 点菜展示表
 */
public class DisplayTable {

  public static List<List<String>> displayTable(List<List<String>> orders) {
    Set<String> itemSet = new HashSet<>();
    // key是table number，value是map，存放着菜名和对应的数量
    Map<Integer, Map<String, Integer>> foodcnt = new HashMap<>();
    for (List<String> order : orders) {
      itemSet.add(order.get(2));
      int id = Integer.parseInt(order.get(1));
      Map<String, Integer> map = foodcnt.getOrDefault(id, new HashMap<>());
      map.put(order.get(2), map.getOrDefault(order.get(2),0)+1);
      foodcnt.put(id, map);
    }

    List<String> names = new ArrayList<>(itemSet);
    Collections.sort(names);

    List<Integer> tables = new ArrayList<>(foodcnt.keySet());
    Collections.sort(tables);

    List<String> header = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    header.add("Table");
    header.addAll(names);
    res.add(header);

    for (int id : tables) {
      List<String> item = new ArrayList<>();
      item.add(String.valueOf(id));
      Map<String, Integer> map = foodcnt.get(id);
      for (String name : names) {

        item.add(String.valueOf(map.getOrDefault(name, 0)));
      }
      res.add(item);
    }
    return res;

  }

}

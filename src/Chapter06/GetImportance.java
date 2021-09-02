
package Chapter06;

import java.util.List;

/**
 * No.690 员工的重要性
 *
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 */
public class GetImportance {

  public static int getImportance(List<Employee> employees, int id) {
    for (Employee employee : employees) {
      if (employee.id == id) {
        if (employee.subordinates.isEmpty()) {
          return employee.importance;
        } else {
          List<Integer> subordinates = employee.subordinates;
          int importance = employee.importance;
          for (int sub : subordinates) {
            importance += getImportance(employees, sub);
          }
          return importance;
        }
      }
    }
    return 0;
  }

}

class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;

}


package Chapter16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

  private List<NestedInteger> nestedList;
  private List<Integer> vals;
  private Iterator<Integer> curr;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.nestedList = nestedList;
    this.vals = new ArrayList<>();
    dfs(nestedList);
    this.curr = vals.iterator();
  }

  @Override
  public boolean hasNext() {
    return curr.hasNext();
  }

  @Override
  public Integer next() {
    return curr.next();
  }

  public void dfs(List<NestedInteger> nestedList) {
    for (NestedInteger nest : nestedList) {
      if (nest.isInteger()) {
        vals.add(nest.getInteger());
      } else {
        dfs(nest.getList());
      }
    }
  }
}

interface NestedInteger {
  public boolean isInteger();

  public Integer getInteger();

  public List<NestedInteger> getList();
}

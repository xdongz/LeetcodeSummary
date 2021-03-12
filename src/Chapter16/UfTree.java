/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter16;

public class UfTree {
  // 结点个数
  private int count;
  // 数组，存储着每个结点的父节点的索引
  private int[] eleGroup;
  // 数组，存储着每个结点所对应的数有多少个元素
  private int[] groupSize;

  public UfTree(int N) {
    this.count = N;

    // 初始化eleGroup，最开始每个元素是单独的一个分组
    eleGroup = new int[N];

    // 初始化groupSize,最开始每个分组的结点数是1
    groupSize = new int[N];

    for (int i = 0; i < N; i++) {
      eleGroup[i] = i;
      groupSize[i] = 1;
    }
  }

  // 得到有多少个分组
  public int getCount() {
    return count;
  }

  // 判断两个结点是否在同一个分组
  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

  // 找到一个结点的根结点的索引
  public int find(int p) {
    while (true) {
      if (eleGroup[p] == p) {
        return p;
      }

      p = eleGroup[p];
    }
  }

  // 将两个结点连起来
  public void union(int p, int q) {
    if (isConnected(p, q)) {
      return;
    }
    // 先把两个结点的根节点找出来
    int pRoot = find(p);
    int qRoot = find(q);

    // 再获取两个根结点所在树的结点个数
    int pGroupSize = groupSize[pRoot];
    int qGroupSize = groupSize[qRoot];

    // 把结点少的数变成结点多的数的子树
    if (pGroupSize < qGroupSize) {
      eleGroup[pRoot] = qRoot;
      // 更新根节点对应的树大小
      groupSize[qRoot] += groupSize[pRoot];
    } else {
      eleGroup[qRoot] = pRoot;
      groupSize[pRoot] += groupSize[qRoot];
    }

    count --;
  }
}

package com.zhangliang.algorithm;
/*
  Minimum Spinning Tree
*/

import java.util.*;

public class MinimumSpinningTree {
  class UnionFind {
    private int[] fathers;

    public UnionFind(int size) {
      fathers = new int[size];
      for (int i = 0; i < size; i++) {
        fathers[i] = i;
      }
    }

    private int findRoot(int a) {
      int father = fathers[a];

      if (father == a) {
        return father;
      }

      int root = findRoot(father);
      fathers[a] = root;
      return root;
    }

    public boolean isConnect(int a, int b) {
      int ra = findRoot(a);
      int rb = findRoot(b);

      return ra == rb;
    }

    public void connect(int a, int b) {
      int ra = findRoot(a);
      int rb = findRoot(b);

      if (ra != rb) {
        fathers[ra] = rb;
      }
    }

  }

  public List<int[]> solve(int n, List<int[]> edges) {
    UnionFind uf = new UnionFind(n);
    Collections.sort(edges, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[2] - b[2];
      }
    });

    List<int[]> res = new ArrayList<>();
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];

      if (!uf.isConnect(a, b)) {
        res.add(edge);
        uf.connect(a, b);
      }
    }

    return res;
  }
}

package com.zhangliang.algorithm;
/*
  Hungarian algorithm to get the maximal matching.
*/

import java.util.*;

public class Hungarian {
  private boolean dfs(int node, int[][] graph, boolean[] checked, int[] matching) {
    for (int next : graph[node]) {
      if (!checked[next]) {
        checked[next] = true;
        if (matching[next] == -1 || dfs(matching[next], graph, checked, matching)) {
          matching[next] = node;
          matching[node] = next;
          return true;
        }
      }
    }
    return false;
  }

  public int[] solve(int n, int[][] graph) {
    int[] matching = new int[n];
    Arrays.fill(matching, -1);
    for (int i = 0; i < n; i++) {
      dfs(i, graph, new boolean[n], matching);
    }
    return matching;
  }
}

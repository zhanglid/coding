package com.zhangliang.algorithm;
/*
  Hungarian algorithm to get the maximal matching.
*/

import java.util.*;

public class Hungarian {
  private boolean dfs(int node, int[] matching, boolean[] checked, int[][] graph) {
    for (int next : graph[node]) {
      if (checked[next]) {
        continue;
      }
      checked[next] = true;
      if (matching[next] == -1 || dfs(matching[next], matching, checked, graph)) {
        matching[next] = node;
        matching[node] = next;
        return true;
      }
    }
    return false;
  }

  public int[] solve(int n, int[][] graph) {
    int[] matching = new int[n];
    Arrays.fill(matching, -1);
    for (int i = 0; i < n; i++) {
      boolean[] checked = new boolean[n];
      dfs(i, matching, checked, graph);
    }
    return matching;
  }
}

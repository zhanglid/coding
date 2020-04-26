package com.zhangliang.google;
/*
一个老美。给N个队伍，两两匹配进行比赛，每两个人比赛会吸引一定的观众。
要求把这N个人分成两组，分组内每两个队伍相互之间进行比赛。
现在建造一个会场举办两个分组之间的座谈会，现在给出所有两两交手的吸引观众的数量，
问，会场最小尺寸多少。 

比如4个队伍0，1，2，3。 
0-1比赛吸引270个人，0-2比赛吸引60个人，0-3比赛吸引20个人，
1-2比赛吸引35个人，1-3比赛吸引90个人，2-3比赛吸引100个人。
那么就把1-2一组，0-3一组（每个组数量可以不一样）。答案是需要35个人。
*/

import java.util.*;

public class MinGameSize {
  private boolean dfs(int node, Set<Integer> s1, Set<Integer> s2, Map<Integer, Set<Integer>> graph) {
    if (s1.contains(node)) {
      return true;
    }
    if (s2.contains(node)) {
      return false;
    }
    s1.add(node);
    for (int next : graph.get(node)) {
      if (!dfs(next, s2, s1, graph)) {
        return false;
      }
    }
    s1.remove(node);
    return true;
  }

  private boolean checkBipartite(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new HashSet<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (!dfs(i, s1, s2, graph)) {
        return false;
      }
    }
    return true;
  }

  private int[][] getEdges(int limit, int n, int[][] sizes) {
    List<int[]> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (sizes[i][j] > limit) {
          edges.add(new int[] { i, j });
        }
      }
    }
    return edges.toArray(new int[0][2]);
  }

  public int getMinSize(int n, int[][] sizes) {
    int l = Integer.MAX_VALUE;
    int r = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        l = Math.min(l, sizes[i][j]);
        r = Math.max(r, sizes[i][j]);
      }
    }
    while (l < r - 1) {
      int mid = l + (r - l) / 2;
      if (checkBipartite(n, getEdges(mid, n, sizes))) {
        r = mid;
      } else {
        l = mid;
      }
    }

    if (checkBipartite(n, getEdges(l, n, sizes))) {
      return l;
    }

    return r;
  }
}

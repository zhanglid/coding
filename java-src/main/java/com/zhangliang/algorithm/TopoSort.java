package com.zhangliang.algorithm;
/*

*/

import java.util.*;

public class TopoSort {
  private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new HashSet<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
    }
    return graph;
  }

  public int[] indegreeSort(int n, int[][] edges) {
    int[] indegree = new int[n];
    for (int[] edge : edges) {
      indegree[edge[1]]++;
    }
    Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
    int[] res = new int[n];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
    int index = 0;
    while (!q.isEmpty()) {
      int node = q.poll();
      res[index++] = node;
      for (int next : graph.get(node)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          q.add(next);
        }
      }
    }

    return res;
  }

  private boolean dfsWithCircleDetect(int node, Stack<Integer> stack, Set<Integer> visited, Set<Integer> path,
      Map<Integer, Set<Integer>> graph) {
    if (visited.contains(node)) {
      return true;
    }
    if (path.contains(node)) {
      return false;
    }
    path.add(node);
    for (int next : graph.get(node)) {
      if (!dfsWithCircleDetect(next, stack, visited, path, graph)) {
        return false;
      }
    }
    stack.push(node);
    visited.add(node);
    path.remove(node);
    return true;
  }

  private void dfs(int node, Stack<Integer> stack, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {
    if (visited.contains(node)) {
      return;
    }
    for (int next : graph.get(node)) {
      dfs(next, stack, visited, graph);
    }
    stack.push(node);
    visited.add(node);
  }

  public int[] dfsSort(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
    Set<Integer> visited = new HashSet<>();

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      dfs(i, stack, visited, graph);
    }

    int[] res = new int[stack.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = stack.pop();
    }
    return res;
  }

  public int[] dfsSortWithCircle(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
    Set<Integer> visited = new HashSet<>();

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (!dfsWithCircleDetect(i, stack, visited, new HashSet<>(), graph)) {
        return null;
      }
    }

    int[] res = new int[stack.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = stack.pop();
    }
    return res;
  }
}

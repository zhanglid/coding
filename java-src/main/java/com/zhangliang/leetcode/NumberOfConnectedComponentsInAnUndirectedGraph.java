package com.zhangliang.leetcode;
/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
(each edge is a pair of nodes), write a function to find the number of 
connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2
Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. Since all 
edges are undirected, [0, 1] is the same as [1, 0] and thus will not 
appear together in edges.
*/

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    private void dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int node) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (Integer other : graph.get(node)) {
            dfs(graph, visited, other);
        }
    }

    private Map<Integer, Set<Integer>> buildMap(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = buildMap(n, edges);
        Set<Integer> visited = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                ans++;
                dfs(graph, visited, i);
            }
        }
        return ans;
    }
}

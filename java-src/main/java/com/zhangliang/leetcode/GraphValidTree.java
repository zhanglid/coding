package com.zhangliang.leetcode;
/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges 
(each edge is a pair of nodes), write a function to check whether 
these edges make up a valid tree.

Example 1:
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true

Example 2:
Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0,1] is the same as [1,0] and thus 
will not appear together in edges.
*/

import java.util.*;

public class GraphValidTree {
    private boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (Integer other : graph.get(node)) {
            if (other == parent) {
                continue;
            }
            if (!dfs(graph, visited, other, node)) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildMap(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public boolean validTree(int n, int[][] edges) {
        if (n < 1) {
            return true;
        }
        Map<Integer, List<Integer>> graph = buildMap(n, edges);
        // Attention: Need to check whether we visited all nodes.
        Set<Integer> visited = new HashSet<>();
        return dfs(graph, visited, 0, -1) && visited.size() == n;
    }
}

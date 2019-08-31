package com.zhangliang.leetcode;
/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to 
finish all courses?

Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

import java.util.*;

public class CourseSchedule {
    private boolean dfs(int index, Map<Integer, Set<Integer>> graph, Set<Integer> path, Set<Integer> visited) {
        if (path.contains(index)) {
            return false;
        }
        path.add(index);
        if (graph.containsKey(index)) {
            for (Integer other : graph.get(index)) {
                if (visited.contains(other)) {
                    continue;
                }
                if (!dfs(other, graph, path, visited)) {
                    return false;
                }
            }
        }
        path.remove(index);
        visited.add(index);
        return true;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            if (!graph.containsKey(pair[0])) {
                graph.put(pair[0], new HashSet<>());
            }
            if (!graph.containsKey(pair[1])) {
                graph.put(pair[1], new HashSet<>());
            }
            graph.get(pair[1]).add(pair[0]);
        }
        return graph;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = buildGraph(prerequisites);
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, new HashSet<>(), visited)) {
                return false;
            }
        }
        return true;
    }
}

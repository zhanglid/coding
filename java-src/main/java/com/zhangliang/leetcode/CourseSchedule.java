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

    private boolean helper(Map<Integer, Set<Integer>> graph, int node, Set<Integer> path, Set<Integer> visited) {
        if (visited.contains(node)) {
            return true;
        }
        if (path.contains(node)) {
            return false;
        }
        if (graph.containsKey(node)) {
            path.add(node);
            for (Integer next : graph.get(node)) {
                if (!helper(graph, next, path, visited)) {
                    return false;
                }
            }
            path.remove(node);
        }
        visited.add(node);
        return true;
    }

    /**
     * Graph: <Integer, Set<Integer>> => to take a, you have to take all courses in
     * the set.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashSet<>());
            }
            graph.get(edge[0]).add(edge[1]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && !helper(graph, i, new HashSet<>(), visited)) {
                return false;
            }
        }
        return true;
    }
}

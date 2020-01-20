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
    private boolean topoCheck(int node, Set<Integer> path, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {
        if (path.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }
        visited.add(node);
        path.add(node);
        for (int neighbor : graph.get(node)) {
            if (!topoCheck(neighbor, path, visited, graph)) {
                return false;
            }
        }
        path.remove(node);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topoCheck(i, new HashSet<>(), visited, graph)) {
                return false;
            }
        }
        return true;
    }
}

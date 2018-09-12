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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] edges) {
        if (n < 1 || edges == null || edges.length < 1) {
            return true;
        }

        Map<Integer, Set<Integer>> outMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            outMap.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            outMap.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!helper(i, visited, new HashSet<>(), outMap)) {
                return false;
            }
        }

        return true;
    }

    private boolean helper(int node, Set<Integer> visited, Set<Integer> path, Map<Integer, Set<Integer>> outMap) {
        if (path.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }
        path.add(node);
        visited.add(node);

        for (int other : outMap.get(node)) {
            if (!helper(other, visited, path, outMap)) {
                return false;
            }
        }
        path.remove(node);
        return true;
    }
}

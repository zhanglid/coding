package com.zhangliang.leetcode;
/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed 
as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to 
finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, 
return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how  
graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

*/

import java.util.*;

public class CourseScheduleII {
    private boolean topoSort(int node, Set<Integer> path, Set<Integer> visited, Stack<Integer> result,
            Map<Integer, Set<Integer>> graph) {
        if (path.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }
        path.add(node);
        visited.add(node);
        for (int next : graph.get(node)) {
            if (!topoSort(next, path, visited, result, graph)) {
                return false;
            }
        }
        result.add(node);
        path.remove(node);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topoSort(i, new HashSet<>(), visited, stack, graph)) {
                return new int[0];
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}

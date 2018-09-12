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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return new int[0];
        }
        if (prerequisites == null) {
            prerequisites = new int[0][];
        }

        List<Set<Integer>> outMap = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            outMap.add(i, new HashSet<>());
        }

        for (int[] pair : prerequisites) {
            outMap.get(pair[1]).add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> pathSet = new HashSet<>();
            if (!visited[i]) {
                if (!helper(i, visited, stack, outMap, pathSet)) {
                    stack.clear();
                    break;
                }
            }
        }

        int[] ans = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index++] = stack.pop();
        }
        return ans;
    }

    private boolean helper(int index, boolean[] visited, Stack<Integer> stack, List<Set<Integer>> outMap,
            Set<Integer> pathSet) {
        if (pathSet.contains(index)) {
            return false;
        }
        pathSet.add(index);
        visited[index] = true;
        for (int x : outMap.get(index)) {
            if (pathSet.contains(x)) {
                return false;
            }
            if (!visited[x]) {
                if (!helper(x, visited, stack, outMap, pathSet)) {
                    return false;
                }
            }
        }

        stack.push(index);
        pathSet.remove(index);
        return true;
    }
}

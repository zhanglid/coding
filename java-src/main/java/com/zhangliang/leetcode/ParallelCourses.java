package com.zhangliang.leetcode;
/*
There are N courses, labelled from 1 to N.

We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: 
course X has to be studied before course Y.

In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.

Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.

Example 1:

Input: N = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: 
In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.

Example 2:

Input: N = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: 
No course can be studied because they depend on each other.
 

Note:

1 <= N <= 5000
1 <= relations.length <= 5000
relations[i][0] != relations[i][1]
There are no repeated relations in the input.
*/

import java.util.*;

// Toposort: time O(n)
public class ParallelCourses {
    private int dfs(int course, Map<Integer, Integer> visited, List<List<Integer>> beforeCourses, Set<Integer> path) {
        if (path.contains(course)) {
            return -1;
        }
        path.add(course);
        int len = 1;
        for (int before : beforeCourses.get(course)) {
            int clen = visited.containsKey(before) ? visited.get(before) : dfs(before, visited, beforeCourses, path);
            if (clen < 0) {
                return clen;
            }
            len = Math.max(clen + 1, len);
        }
        visited.put(course, len);
        path.remove(course);
        return len;
    }

    public int minimumSemesters(int N, int[][] relations) {
        List<List<Integer>> beforeCourses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            beforeCourses.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            beforeCourses.get(relation[1] - 1).add(relation[0] - 1);
        }
        Map<Integer, Integer> visited = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            if (!visited.containsKey(i)) {
                int cLen = dfs(i, visited, beforeCourses, new HashSet<>());
                if (cLen < 0) {
                    return -1;
                }
                maxLen = Math.max(cLen, maxLen);
            }
        }
        return maxLen;
    }
}

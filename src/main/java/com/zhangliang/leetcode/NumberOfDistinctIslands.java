package com.zhangliang.leetcode;
/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are 
surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only 
if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.

Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
*/

import java.util.*;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }

    private static final int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        grid[i][j] = 0;
        for (int t = 0; t < 4; t++) {
            int ni = i + dirs[t][0];
            int nj = j + dirs[t][1];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] == 0) {
                continue;
            }
            sb.append(t);
            dfs(grid, ni, nj, sb);
        }
        sb.append('.');
    }
}

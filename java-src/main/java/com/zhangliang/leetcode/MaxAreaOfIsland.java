package com.zhangliang.leetcode;
/*
Given a non-empty 2D array grid of 0's and 1's, an island is a 
group of 1's (representing land) connected 4-directionally 
(horizontal or vertical.) You may assume all four edges of 
the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. 
(If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, 
because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
*/

import java.util.*;

public class MaxAreaOfIsland {
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    /**
     * Run bfs from the point to remove the whole island and return the area.
     */
    private int bfs(int[][] grid, int i, int j) {
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        grid[i][j] = 0;
        while (!queue.isEmpty()) {
            area++;
            int[] pos = queue.poll();
            for (int[] dir : DIRS) {
                int ni = pos[0] + dir[0];
                int nj = pos[1] + dir[1];

                if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] == 0) {
                    continue;
                }
                grid[ni][nj] = 0;
                queue.add(new int[] { ni, nj });
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(bfs(grid, i, j), max);
                }
            }
        }
        return max;
    }
}

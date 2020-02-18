package com.zhangliang.leetcode;
/*\
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water 
and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid 
are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

import java.util.*;

public class NumberOfIslands {
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length) {
                continue;
            }
            dfs(grid, ni, nj);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}

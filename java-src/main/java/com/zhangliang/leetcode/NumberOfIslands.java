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

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { i, j });
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int ni = pos[0] + dir[0];
                int nj = pos[1] + dir[1];
                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == '1') {
                    grid[ni][nj] = '0';
                    queue.add(new int[] { ni, nj });
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }
}

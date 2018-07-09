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
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    expand(grid, i, j);
                }
            }
        }

        return count;
    }

    private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private int[] getPos(int x, int n) {
        int i = x / n;
        int j = x % n;
        return new int[] { i, j };
    }

    private void expand(char[][] grid, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        grid[i][j] = '0';
        queue.add(i * grid[0].length + j);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int[] curPos = getPos(cur, grid[0].length);
            int ci = curPos[0];
            int cj = curPos[1];
            for (int[] dir : dirs) {
                int ni = ci + dir[0];
                int nj = cj + dir[1];
                if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] != '1') {
                    continue;
                }
                grid[ni][nj] = '0';
                queue.add(ni * grid[0].length + nj);
            }
        }
    }
}

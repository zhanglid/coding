package com.zhangliang.leetcode;
/*
In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

1 <= grid.length, grid[i].length <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.
*/

public class PathWithMaximumGold {
    private static final int[][] DIRS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        if (grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int value = 0;
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || visited[ni][nj]) {
                continue;
            }
            value = Math.max(value, dfs(ni, nj, visited, grid));
        }
        visited[i][j] = false;
        return value + grid[i][j];
    }

    public int getMaximumGold(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    result = Math.max(result, dfs(i, j, visited, grid));
                }
            }
        }
        return result;
    }
}

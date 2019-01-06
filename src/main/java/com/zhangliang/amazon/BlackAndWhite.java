package com.zhangliang.amazon;
/*
Given a black and white image in the form of 2D array, count how many black regions are there in 
the image. A regiion is defined as a contiguous of black pixels are adjacent to each other if they 
are horizontally, vertically or diagonally touching each other.

Notes:
1. The first line contains the height H of the image.
2. The second line contains the width W of the image.
3. Then there are H lines, each containing W characters separated by a single space.
4. Each character is either a W or B (upper case only)

Example 1:
5
8
W W B W B W W
W W B B W W B
B W W B B W B
W B W W W W B
W W W W W B B

The above image has 3 black regions.
*/

import java.util.LinkedList;
import java.util.Queue;

public class BlackAndWhite {
    static final int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, 1 }, { 1, 1 }, { -1, -1 },
            { 1, 1 } };

    static private void expand(int i, int j, boolean[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            grid[point[0]][point[1]] = false;
            for (int[] dir : dirs) {
                int ni = point[0] + dir[0];
                int nj = point[1] + dir[1];
                if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || !grid[ni][nj]) {
                    continue;
                }
                queue.add(new int[] { ni, nj });
            }
        }
    }

    static public int solve(boolean[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    ans++;
                    expand(i, j, grid);
                }
            }
        }

        return ans;
    }
}

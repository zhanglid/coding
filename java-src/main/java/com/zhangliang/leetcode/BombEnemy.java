package com.zhangliang.leetcode;
/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty 
'0' (the number zero), return the maximum enemies you can kill using one 
bomb. The bomb kills all the enemies in the same row and column from the 
planted point until it hits the wall since the wall is too strong to be 
destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3 
Explanation: For the given grid,

0 E 0 0 
E 0 W E 
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.

*/

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        // up
        int[][] dpUp = new int[grid.length][grid[0].length];
        for (int i = 1; i < dpUp.length; i++) {
            for (int j = 0; j < dpUp[0].length; j++) {
                if (grid[i - 1][j] == 'W') {
                    continue;
                }
                dpUp[i][j] = dpUp[i - 1][j] + (grid[i - 1][j] == 'E' ? 1 : 0);
            }
        }

        // left
        int[][] dpLeft = new int[grid.length][grid[0].length];
        for (int i = 0; i < dpLeft.length; i++) {
            for (int j = 1; j < dpLeft[0].length; j++) {
                if (grid[i][j - 1] == 'W') {
                    continue;
                }
                dpLeft[i][j] = dpLeft[i][j - 1] + (grid[i][j - 1] == 'E' ? 1 : 0);
            }
        }

        // down
        int[][] dpDown = new int[grid.length][grid[0].length];
        for (int i = dpDown.length - 2; i >= 0; i--) {
            for (int j = dpDown[0].length - 1; j >= 0; j--) {
                if (grid[i + 1][j] == 'W') {
                    continue;
                }
                dpDown[i][j] = dpDown[i + 1][j] + (grid[i + 1][j] == 'E' ? 1 : 0);
            }
        }

        // right
        int[][] dpRight = new int[grid.length][grid[0].length];
        for (int i = dpRight.length - 1; i >= 0; i--) {
            for (int j = dpRight[0].length - 2; j >= 0; j--) {
                if (grid[i][j + 1] == 'W') {
                    continue;
                }
                dpRight[i][j] = dpRight[i][j + 1] + (grid[i][j + 1] == 'E' ? 1 : 0);
            }
        }

        int ans = 0;
        // find the ans
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    int sum = dpDown[i][j];
                    sum += dpUp[i][j];
                    sum += dpLeft[i][j];
                    sum += dpRight[i][j];
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }
}

package com.zhangliang.leetcode;
/*
Given a m x n grid filled with non-negative numbers, find a path from 
top left to bottom right which minimizes the sum of all numbers along 
its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    dp[i][j] = Math.min(i - 1 >= 0 ? dp[i - 1][j] : Integer.MAX_VALUE,
                            j - 1 >= 0 ? dp[i][j - 1] : Integer.MAX_VALUE);
                }
                dp[i][j] += grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}

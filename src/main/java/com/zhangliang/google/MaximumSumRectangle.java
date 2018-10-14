package com.zhangliang.google;
/*
Given a 2D array, find the maximum sum subarray in it. For example, in 
the following 2D array, the maximum sum subarray is highlighted with blue 
rectangle and sum of this subarray is 29.

Input:
First line of every test case consists of T test case. First line of every 
test case consists of 2 integers R and C , denoting number of rows and columns. 
Second line consists of R*C spaced integers denoting number of elements in array.

Output:
Single line output, print the Max sum forming a rectangle in a 2-D matrix

Example:
Input:
[
    [1 2 -1 -4 -20],
    [ -8 -3 4 2 1 ],
    [ 3 8 10 1 3 ],
    [ -4 -1 1 7 -6 ]
]

Ouptut:
29
*/

public class MaximumSumRectangle {
    public int solve(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        // j1...j2...i => sum
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int l = 0; l < dp[0].length; l++) {
                int sum = 0;
                for (int r = l; r < dp[0].length; r++) {
                    sum += grid[i][r];
                    dp[i][l][r] = sum + (i > 0 ? dp[i - 1][l][r] : 0);
                }
            }
        }

        int ans = 0;

        for (int l = 0; l < grid[0].length; l++) {
            for (int r = l; r < grid[0].length; r++) {
                int min = 0;
                for (int i = 0; i < grid.length; i++) {
                    ans = Math.max(ans, dp[i][l][r] - min);
                    min = Math.min(min, dp[i][l][r]);
                }
            }
        }

        return ans;
    }
}

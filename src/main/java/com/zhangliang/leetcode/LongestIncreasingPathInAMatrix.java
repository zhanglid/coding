package com.zhangliang.leetcode;
/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may 
NOT move diagonally 
or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class LongestIncreasingPathInAMatrix {
    private int[][] cache = null;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return 0;
        }

        cache = new int[matrix.length][matrix[0].length];
        int ans = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(ans, helper(i, j, matrix));
            }
        }

        return ans;
    }

    private static final int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private int helper(int i, int j, int[][] matrix) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        int ans = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[0].length || matrix[ni][nj] <= matrix[i][j]) {
                continue;
            }
            ans = Math.max(ans, helper(ni, nj, matrix));
        }

        cache[i][j] = ans + 1;
        return ans + 1;
    }
}

package com.zhangliang.leetcode;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0);
                    dp[i][j] = Math.min(dp[i][j], i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0);
                    dp[i][j] += 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}

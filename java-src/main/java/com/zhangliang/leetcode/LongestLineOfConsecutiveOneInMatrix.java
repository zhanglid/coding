package com.zhangliang.leetcode;
/*
Given a 01 matrix M, find the longest line of consecutive one in the matrix. 
The line could be horizontal, vertical, diagonal or anti-diagonal.

Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3
Hint: The number of elements in the given matrix will not exceed 10,000.
*/

public class LongestLineOfConsecutiveOneInMatrix {
    // 0 left, 1 up, 2 diag, 3 anti-diag
    public int longestLine(int[][] M) {
        if (M.length < 1 || M[0].length < 1) {
            return 0;
        }
        int[][][] dp = new int[M.length][M[0].length][4];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                dp[i][j][0] = j - 1 >= 0 ? dp[i][j - 1][0] + 1 : 1;
                dp[i][j][1] = i - 1 >= 0 ? dp[i - 1][j][1] + 1 : 1;
                dp[i][j][2] = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1][2] + 1 : 1;
                dp[i][j][3] = i - 1 >= 0 && j + 1 < M[0].length ? dp[i - 1][j + 1][3] + 1 : 1;
            }
        }
        int max = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                for (int k = 0; k < 4; k++) {
                    max = Math.max(max, dp[i][j][k]);
                }
            }
        }
        return max;
    }
}

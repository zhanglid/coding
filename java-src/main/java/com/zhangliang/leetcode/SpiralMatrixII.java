package com.zhangliang.leetcode;
/*
Given a positive integer n, generate a square matrix filled with elements 
from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return null;
        }
        int[][] ans = new int[n][n];
        int si = 0;
        int sj = 0;
        int cur = 1;
        while (n > 0) {
            for (int j = sj; j < sj + n; j++) {
                ans[si][j] = cur++;
            }

            for (int i = si + 1; i < si + n; i++) {
                ans[i][sj + n - 1] = cur++;
            }

            for (int j = sj + n - 2; j >= sj; j--) {
                ans[si + n - 1][j] = cur++;
            }

            for (int i = si + n - 2; i > si; i--) {
                ans[i][sj] = cur++;
            }
            n -= 2;
            si += 1;
            sj += 1;
        }

        return ans;
    }
}

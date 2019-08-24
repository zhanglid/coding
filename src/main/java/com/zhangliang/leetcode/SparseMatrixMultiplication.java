package com.zhangliang.leetcode;
/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

import java.util.*;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null || A.length < 1 || A[0].length < 1 || B.length < 1 || B[0].length < 1) {
            return null;
        }
        int[][] ans = new int[A.length][B[0].length];
        List<int[]> nonZeroAList = new ArrayList<>();
        List<int[]> nonZeroBList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != 0) {
                    nonZeroAList.add(new int[] { i, j });
                }
            }
        }

        for (int i = 0; i < B[0].length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] != 0) {
                    nonZeroBList.add(new int[] { j, i });
                }
            }
        }

        for (int[] aPos : nonZeroAList) {
            for (int[] bPos : nonZeroBList) {
                if (aPos[1] == bPos[0]) {
                    ans[aPos[0]][bPos[1]] += A[aPos[0]][aPos[1]] * B[bPos[0]][bPos[1]];
                }
            }
        }

        return ans;
    }
}

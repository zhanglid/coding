package com.zhangliang.leetcode;
/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner 
(row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which 
contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
*/

public class RangeSumQuery2dImmutable {
    static class NumMatrix {
        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix.length < 1 || matrix[0].length < 1) {
                return;
            }
            sums = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                int sum = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j];
                    sums[i][j] = (i > 0 ? sums[i - 1][j] : 0) + sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sums == null) {
                return 0;
            }
            return sums[row2][col2] - (row1 > 0 ? sums[row1 - 1][col2] : 0) - (col1 > 0 ? sums[row2][col1 - 1] : 0)
                    + (row1 > 0 && col1 > 0 ? sums[row1 - 1][col1 - 1] : 0);
        }
    }

}

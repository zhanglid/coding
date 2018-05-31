package com.zhangliang.leetcode;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix 
in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return ans;
        }

        int si = 0;
        int sj = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        while (m >= 1 && n >= 1) {
            for (int j = sj; j < sj + n; j++) {
                ans.add(matrix[si][j]);
            }

            for (int i = si + 1; i < si + m; i++) {
                ans.add(matrix[i][sj + n - 1]);
            }

            if (m > 1) {
                for (int j = sj + n - 2; j >= sj; j--) {
                    ans.add(matrix[si + m - 1][j]);
                }
            }

            if (n > 1) {
                for (int i = si + m - 2; i >= si + 1; i--) {
                    ans.add(matrix[i][sj]);
                }
            }

            m -= 2;
            n -= 2;
            si += 1;
            sj += 1;
        }

        return ans;
    }
}

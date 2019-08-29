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

import java.util.*;

public class SpiralMatrix {
    private static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        int di = 0;
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return ans;
        }
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (ans.size() < matrix.length * matrix[0].length) {
            ans.add(matrix[i][j]);
            int ni = i + dirs[di][0];
            int nj = j + dirs[di][1];
            int tryCount = 0;
            while (tryCount < 4 && (ni < top || ni > bottom || nj < left || nj > right)) {
                switch (di) {
                case 0:
                    top++;
                    break;
                case 1:
                    right--;
                    break;
                case 2:
                    bottom--;
                    break;
                case 3:
                    left++;
                    break;
                default:
                    break;
                }
                di++;
                if (di >= 4) {
                    di -= 4;
                }
                ni = i + dirs[di][0];
                nj = j + dirs[di][1];
                tryCount++;
            }
            if (tryCount >= 4) {
                break;
            }
            i = ni;
            j = nj;
        }

        return ans;
    }
}

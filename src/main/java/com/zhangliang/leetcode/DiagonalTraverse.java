package com.zhangliang.leetcode;
/*
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal 
order as shown in the below image.

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:
 

Note:

The total number of elements of the given matrix will not exceed 10,000.
*/

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length < 1) {
            return new int[0];
        }
        int[] ans = new int[matrix.length * matrix[0].length];
        int r = 0;
        int c = 0;
        boolean isUp = true;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = matrix[r][c];
            if (isUp) {
                if (r < 1 || c + 1 >= matrix[0].length) {
                    isUp = false;
                    if (r < 1 && c + 1 < matrix[0].length) {
                        c++;
                    } else {
                        r++;
                    }
                } else {
                    r--;
                    c++;
                }
            } else {
                if (c < 1 || r + 1 >= matrix.length) {
                    isUp = true;
                    if (c < 1 && r + 1 < matrix.length) {
                        r++;
                    } else {
                        c++;
                    }
                } else {
                    r++;
                    c--;
                }
            }
        }
        return ans;
    }
}

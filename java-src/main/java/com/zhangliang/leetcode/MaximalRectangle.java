package com.zhangliang.leetcode;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing 
only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return 0;
        }

        int ans = 0;
        int[] count = new int[matrix[0].length];
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '1') {
                    count[i]++;
                } else {
                    count[i] = 0;
                }
            }

            int[] left = new int[matrix[0].length];

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < row.length; i++) {
                while (!stack.isEmpty() && count[stack.peek()] >= count[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = stack.peek();
                }

                stack.push(i);
            }

            stack.clear();

            for (int i = row.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && count[stack.peek()] >= count[i]) {
                    stack.pop();
                }

                int right = row.length;
                if (!stack.isEmpty()) {
                    right = stack.peek();
                }

                ans = Math.max(ans, (right - left[i] - 1) * count[i]);

                stack.push(i);
            }
        }

        return ans;
    }
}

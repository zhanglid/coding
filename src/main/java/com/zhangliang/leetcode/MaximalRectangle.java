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
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
                while (!stack.isEmpty() && dp[stack.peek()] >= dp[j]) {
                    stack.pop();
                }
                int left = stack.isEmpty() ? 0 : (stack.peek() + 1);
                ans = Math.max(ans, dp[j] * (j - left + 1));
                stack.push(j);
            }
        }
        return ans;
    }
}

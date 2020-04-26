package com.zhangliang.google;

import java.util.*;

/*
Given a N*N matrix containing only 0s and 1s, the task is to count the number of submatrices containing all 1s.

Examples:

Input : arr[][] = {{1, 1, 1},
                   {1, 1, 1},
                   {1, 1, 1}}
Output : 36
Explanation: All the possible submatrices will have only 1s.
Since, there are 36 submatrices in total, ans = 36

Input : {{1, 1, 1},
        {1, 0, 1},
        {1, 1, 1}}
Output : 20
  Assumptions: 
  Approach: 
  DataStructure: 
  Complexity: 
      Time: 
      Space: 
*/

public class NumberOfSubmatricesWithAllOnes {
  private boolean checkAllOne(int[][] nums, int i, int j, int w, int h) {
    for (int ti = i; ti < i + h; ti++) {
      for (int tj = j; tj < j + w; tj++) {
        if (nums[ti][tj] != 1) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Time O(n^6), Space: O(1)
   */
  public int solveBruteForce(int[][] nums) {
    int res = 0;
    int m = nums.length;
    if (m < 1) {
      return res;
    }
    int n = nums[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int h = 1; i + h - 1 < m; h++) {
          for (int w = 1; j + w - 1 < n; w++) {
            if (checkAllOne(nums, i, j, w, h)) {
              res++;
            }
          }
        }
      }
    }
    return res;
  }

  /**
   * Compress 2d into 1d
   */
  public int solveDp(int[][] nums) {
    int m = nums.length;
    if (m < 1) {
      return 0;
    }
    int n = nums[0].length;
    int res = 0;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (nums[i][j] == 1) {
          dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j] : 0) + 1;
        }
      }
      for (int p = 0; p <= i; p++) {
        // Compress into a row
        int[] row = new int[n];
        for (int t = 0; t < n; t++) {
          row[t] = dp[i][t] - (p - 1 >= 0 ? dp[p - 1][t] : 0);
        }
        int c = 0;
        for (int h : row) {
          if (h == i - p + 1) {
            c++;
          } else {
            c = 0;
          }
          res += c;
        }
      }
    }
    return res;
  }

  private int getCnt(int[] nums) {
    int res = 0;
    Stack<Integer> stack = new Stack<>();
    int c = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      while (!stack.isEmpty() && num <= nums[stack.peek()]) {
        int index = stack.pop();
        int li = stack.isEmpty() ? -1 : stack.peek();
        c -= (index - li) * (nums[index] - num);
      }
      c += num;
      res += c;
      stack.push(i);
    }
    return res;
  }

  public int solveStack(int[][] nums) {
    int m = nums.length;
    if (m < 1) {
      return 0;
    }
    int n = nums[0].length;
    int res = 0;
    int[] level = new int[n];
    for (int[] row : nums) {
      for (int i = 0; i < n; i++) {
        if (row[i] == 1) {
          level[i]++;
        } else {
          level[i] = 0;
        }
      }

      res += getCnt(level);
    }

    return res;
  }
}

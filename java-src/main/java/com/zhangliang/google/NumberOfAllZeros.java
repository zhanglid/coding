package com.zhangliang.google;
/*
  是给一个字符串只有1，0，count substring only contains 0.。。
  比如 10011000 就是0，0，00，0，0，0，00，00，000 返回9
  1. follow up是 给一个matrix count submatrix only contains 0.
  2. 2D 里面求array
*/

import java.util.*;

public class NumberOfAllZeros {
  public int countZero(String s) {
    int res = 0;
    int c = 0;
    for (char x : s.toCharArray()) {
      if (x == '0') {
        c++;
      } else {
        c = 0;
      }
      res += c;
    }
    return res;
  }

  public int countSubmatrixZero(int[][] grid) {
    int res = 0;
    if (grid == null || grid.length < 1 || grid[0].length < 1) {
      return res;
    }

    int m = grid.length;
    int n = grid[0].length;

    int[] dp = new int[n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          dp[j]++;
        } else {
          dp[j] = 0;
        }
      }

      Stack<Integer> stack = new Stack<>();
      int c = 0;
      for (int j = 0; j < n; j++) {
        while (!stack.isEmpty() && dp[j] <= dp[stack.peek()]) {
          int index = stack.pop();
          int li = stack.isEmpty() ? -1 : stack.peek();
          c -= (index - li) * (dp[index] - dp[j]);
        }

        stack.push(j);
        c += dp[j];
        res += c;
      }
    }

    return res;
  }
}

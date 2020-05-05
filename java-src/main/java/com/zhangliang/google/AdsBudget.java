package com.zhangliang.google;
/*
Given a budget (W), buy ads. The costs and rewards of ads on each day are given by array (rewards and costs). If you bought ads on day t, you cannot buy ads on t+1. Find the max reward under budget. 解法：dynamic programming. max_reward[date][budget] = max(max_reward[date-1][budget], rewards[date] + max_reward[date-2][budget-costs[date])


Follow-up: return the dates of ads that achieved the best reward.

*/

import java.util.*;

public class AdsBudget {
  public int solve(int[] rewards, int[] costs, int budget) {
    int n = costs.length;
    int[][] dp = new int[n + 1][budget + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= budget; j++) {
        dp[i + 1][j] = dp[i][j];
        if (costs[i] <= j) {
          dp[i + 1][j] = Math.max(dp[i + 1][j], rewards[i] + dp[i][j - costs[i]]);
        }
      }
    }
    return dp[n][budget];
  }

  public List<Integer> solveFollowUp(int[] rewards, int[] costs, int budget) {
    int n = costs.length;
    int[][] dp = new int[n + 1][budget + 1];
    boolean[][] selected = new boolean[n + 1][budget + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= budget; j++) {
        dp[i + 1][j] = dp[i][j];
        if (costs[i] <= j) {
          if (dp[i + 1][j] < rewards[i] + dp[i][j - costs[i]]) {
            dp[i + 1][j] = rewards[i] + dp[i][j - costs[i]];
            selected[i + 1][j] = true;
          }
        }
      }
    }
    List<Integer> res = new ArrayList<>();
    int leftBudget = budget;
    for (int i = n - 1; i >= 0; i--) {
      if (selected[i][leftBudget]) {
        leftBudget -= costs[i];
        res.add(i);
      }
    }
    return res;
  }
}

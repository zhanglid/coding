package com.zhangliang.google;
/*
@TODO: Google
Given a budget (W), buy ads. The costs and rewards of ads on each day are given by array (rewards and costs). If you bought ads on day t, you cannot buy ads on t+1. Find the max reward under budget.

解法：dynamic programming. max_reward[date][budget] = max(max_reward[date-1][budget], rewards[date] + max_reward[date-2][budget-costs[date])

Follow-up: return the dates of ads that achieved the best reward.

*/

public class AdsBudget {
  public int solve() {

  }
}

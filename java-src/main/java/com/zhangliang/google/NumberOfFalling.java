package com.zhangliang.google;
/*
  xxxxx在偶数轮可以滚落1, 3或者4个stairs，奇数轮可以滚1, 2或者4 stairs，然后中间会有一些sticky stairs，
  掉到sticky stairs的时候不能move, 小球直接挂掉。问的是从这个n个stairs高的楼梯，
  小球有多少种方法能够到达ground，也就是stair为0的这一层，超过的话，比如-3，-2，-1也算是到达ground。

  (B)
  --+
  3 |
    +--+
    2 |
      +--+
        1 |
  --------+---------
  用dp做，但我用dfs的暴力解，最后要用dp做的时候时间不够了

  n -> n - 1
    -> n - 3
    -> n - 4

  int[] dp 
  dp[i] -> how many ways to get level i.
  from n to 0
*/

import java.util.*;

public class NumberOfFalling {
  private static final int[] ODD_JUMP = new int[] { 1, 2, 4 };
  private static final int[] EVEN_JUMP = new int[] { 1, 3, 4 };

  public int solve(int n, int[] stickyStairs) {
    int[] dp = new int[n + 1];
    Set<Integer> sticky = new HashSet<>();
    for (int stair : stickyStairs) {
      sticky.add(stair);
    }
    dp[n] = 1;
    for (int i = n; i > 0; i--) {
      if (sticky.contains(i)) {
        continue;
      }
      for (int step : i % 2 == 0 ? EVEN_JUMP : ODD_JUMP) {
        int t = Math.max(0, i - step);
        dp[t] += dp[i];
        if (t == 0) {
          break;
        }
      }
    }

    return dp[0];
  }
}

package com.zhangliang.google;
/*
  判断覆盖网络需要的最少点数给一个数组每个位置代表当前位置放路由器
  能覆盖的范围 （idx+-a[idx]），
  求最少要放几个点能覆盖整个范围，
  比如a=[1, 1, 2, 1, 1] 答案是1 放在a[2]即可覆盖.
*/

public class ArrayCover {
  public int solve(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n + 1];

    for (int i = 0; i < n; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = i; j >= 0; j--) {
        if (j + arr[j] >= i) {
          int pi = j - arr[j] - 1;
          dp[i] = Math.min(dp[i], 1 + (pi < 0 ? 0 : dp[pi]));
        }
      }
    }

    return dp[n - 1];
  }
}

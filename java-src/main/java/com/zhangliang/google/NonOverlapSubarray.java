package com.zhangliang.google;
/*
  [2, 4, 1, 2, 3, 4, 5, 1], K = 6，
  求两个没有overlapped的subarray，每一个subarray里的和为K
  且两个subarray的size之和最小， 
  这题结果应该是subarray[0: 1]， subarray[6: 7], size之和最小，是4
*/

import java.util.*;

public class NonOverlapSubarray {
  public int getMinSize(int[] input, int k) {
    int n = input.length;
    Map<Integer, Integer> prefixSum = new HashMap<>();
    int[] dp = new int[n]; // min size of valid subarray before i, 0 non
    prefixSum.put(0, -1);
    int sum = 0;
    int res = -1;
    for (int i = 0; i < n; i++) {
      sum += input[i];
      if (i > 0 && dp[i - 1] > 0) {
        dp[i] = dp[i - 1];
      }
      if (prefixSum.containsKey(sum - k)) {
        int l = prefixSum.get(sum - k);
        if (l >= 0 && dp[l] > 0) {
          res = res == -1 ? (dp[l] + i - l) : Math.min(dp[l] + i - l, res);
        }
        if (dp[i] == 0 || dp[i] > i - l) {
          dp[i] = i - l;
        }
      }
      prefixSum.put(sum, i);
    }

    return res;
  }
}

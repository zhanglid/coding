package com.zhangliang.google;
/*
  一个大小为N的数组 取K个数 每次从最左或最右取 求sum max

  然后follow up是取出的K个数需要和一个长为K的给定数组做inner product 求max
  我傻了上来就DP, 其实第一问brute force更高效。。
*/

public class MaximumInnerProductOfKNum {
  public int maxSumFromTwoSides(int[] arr, int k) {
    int n = arr.length;
    int[] prefixSum = new int[k + 1];
    int[] suffixSum = new int[k + 1];
    int pSum = 0;
    int sSum = 0;
    for (int i = 0; i < k; i++) {
      pSum += arr[i];
      prefixSum[i + 1] = pSum;
      sSum += arr[n - 1 - i];
      suffixSum[i + 1] = sSum;
    }

    int res = 0;
    for (int i = 0; i <= k; i++) {
      res = Math.max(res, prefixSum[i] + suffixSum[k - i]);
    }

    return res;
  }

  /**
   * 0-1 backpack
   */
  public int maxInnerProduct(int[] arr, int k, int[] others) {
    if (arr.length < 1 || k < 1) {
      return 0;
    }

    int n = arr.length;

    int[][] dp = new int[n + 1][k + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k && j <= i; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], arr[i - 1] * others[j - 1] + dp[i - 1][j - 1]);
      }
    }

    int res = 0;
    for (int i = 1; i <= n; i++) {
      res = Math.max(res, dp[i][k]);
    }
    return res;
  }
}

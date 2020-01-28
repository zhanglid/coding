package com.zhangliang.leetcode;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

*/

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) {
            return 0;
        }
        if (k > prices.length / 2) {

            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }

            return ans;
        }
        Map<Integer, Integer> dpRelease = new HashMap<>();
        Map<Integer, Integer> dpHold = new HashMap<>();

        dpRelease.put(0, 0);

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (dpHold.containsKey(j - 1)) {
                    int max = dpRelease.getOrDefault(j, Integer.MIN_VALUE);
                    max = Math.max(max, dpHold.get(j - 1) + prices[i]);
                    dpRelease.put(j, max);
                }

                if (dpRelease.containsKey(j)) {
                    int max = Math.max(dpHold.getOrDefault(j, Integer.MIN_VALUE), dpRelease.get(j) - prices[i]);
                    dpHold.put(j, max);
                }
            }
        }

        int ans = 0;
        for (int value : dpRelease.values()) {
            ans = Math.max(ans, value);
        }

        return ans;
    }
}

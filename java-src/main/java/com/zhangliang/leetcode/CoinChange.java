package com.zhangliang.leetcode;
/*
You are given coins of different denominations and a total 
amount of money amount. Write a function to compute the fewest 
number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of 
the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins.length < 1) {
            return amount == 0 ? 0 : -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int a = 1; a <= amount; a++) {
            dp[0][a] = -1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int a = 1; a <= amount; a++) {
                dp[i][a] = dp[i - 1][a];
                if (a >= coins[i - 1]) {
                    int useCoinValue = dp[i][a - coins[i - 1]];
                    if (useCoinValue != -1) {
                        if (dp[i][a] == -1) {
                            dp[i][a] = useCoinValue + 1;
                        } else {
                            dp[i][a] = Math.min(useCoinValue + 1, dp[i][a]);
                        }
                    }
                }
            }
        }
        return dp[coins.length][amount];
    }
}

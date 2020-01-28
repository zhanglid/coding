package com.zhangliang.leetcode;
/*
There are a row of n houses, each house can be painted with one of the 
three colors: red, blue or green. The cost of painting each house with 
a certain color is different. You have to paint all the houses such that 
no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a 
n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 
0 with color red; costs[1][2] is the cost of painting house 1 with color 
green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.
*/

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length < 1) {
            return 0;
        }
        int[] dp = new int[costs[0].length];
        for (int[] cost : costs) {
            // Get left min
            int[] leftMins = new int[dp.length];
            int min = -1;
            for (int i = 0; i < dp.length; i++) {
                leftMins[i] = min;
                min = min == -1 ? dp[i] : Math.min(dp[i], min);
            }

            // Right min
            int[] rightMins = new int[dp.length];
            min = -1;
            for (int i = dp.length - 1; i >= 0; i--) {
                rightMins[i] = min;
                min = min == -1 ? dp[i] : Math.min(dp[i], min);
            }

            // Calc next
            for (int i = 0; i < dp.length; i++) {
                dp[i] = (((rightMins[i] == -1 || (leftMins[i] != -1) && (leftMins[i] < rightMins[i])) ? leftMins[i]
                        : rightMins[i]) + cost[i]);
            }
        }

        int minCost = dp[0];
        for (int i = 0; i < dp.length; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        return minCost;
    }
}

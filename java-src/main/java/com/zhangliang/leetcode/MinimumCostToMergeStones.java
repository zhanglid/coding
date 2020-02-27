package com.zhangliang.leetcode;
/*
There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.

A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of 
stones in these K piles.

Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.

Example 1:

Input: stones = [3,2,4,1], K = 2
Output: 20
Explanation: 
We start with [3, 2, 4, 1].
We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
We merge [4, 1] for a cost of 5, and we are left with [5, 5].
We merge [5, 5] for a cost of 10, and we are left with [10].
The total cost was 20, and this is the minimum possible.

Example 2:

Input: stones = [3,2,4,1], K = 3
Output: -1
Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.

Example 3:

Input: stones = [3,5,1,2,6], K = 3
Output: 25
Explanation: 
We start with [3, 5, 1, 2, 6].
We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
We merge [3, 8, 6] for a cost of 17, and we are left with [17].
The total cost was 25, and this is the minimum possible.
 

Note:

1 <= stones.length <= 30
2 <= K <= 30
1 <= stones[i] <= 100
*/

public class MinimumCostToMergeStones {
    private int sum(int[] nums, int i, int j) {
        int value = 0;
        for (; i <= j; i++) {
            value += nums[i];
        }
        return value;
    }

    /**
     * dp[i][j][k]: The cost to merge nums from i...j into k + 1 nums dp[i][j][k]
     * 
     * dp[i][j][k] = sum(i, j) or -1 ,k = 0 base case (j - i - 1) % (K - 1) == 0
     * dp[i][t][0] + dp[t + 1][j][k - 1] ,k > 0
     * 
     */
    public int mergeStones(int[] stones, int K) {
        int[][][] dp = new int[stones.length][stones.length][K];
        for (int i = 0; i < stones.length; i++) {
            for (int j = i; j < stones.length; j++) { // Iterate through every range
                if (j - i + 1 == K) {
                    dp[i][j][0] = sum(stones, i, j);
                }
                // Check each k
                for (int k = 1; k < K; k++) {
                    dp[i][j][k] = -1;
                    for (int t = i; t + 1 < j; t++) {
                        if (dp[i][t][0] != -1 && dp[t + 1][j][k - 1] != -1) {
                            int cost = dp[i][t][0] + dp[t + 1][j][k - 1];
                            dp[i][j][k] = dp[i][j][k] == -1 ? cost : Math.min(dp[i][j][k], cost);
                        }
                    }
                }
                // k == 0
                if ((j - i + 1) % (K - 1) == 0 && (dp[i][j][K - 1] != -1 || dp[i][j][K - 1])) {
                    dp[i][j][0] = dp[i][j][K - 1] + sum(stones, i, j);
                } else {
                    dp[i][j][0] = -1;
                }
            }
        }
        return dp[0][stones.length - 1][0];
    }
}

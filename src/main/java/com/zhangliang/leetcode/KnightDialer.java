package com.zhangliang.leetcode;
/*
A chess knight can move as indicated in the chess diagram below:

|1|2|3|
|4|5|6|
|7|8|9|
  |0|

This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the 
knight makes N-1 hops.  Each hop must be from one key to another numbered key.
Each time it lands on a key (including the initial placement of the knight), it presses the number 
of that key, pressing N digits total.
How many distinct numbers can you dial in this manner?
Since the answer may be large, output the answer modulo 10^9 + 7.

Example 1:
Input: 1
Output: 10

Example 2:
Input: 2
Output: 20

Example 3:
Input: 3
Output: 46

Note:
1 <= N <= 5000
*/

public class KnightDialer {
    private static final int MOD = 1_000_000_007;
    private static final int[][] prevs = new int[][] { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {},
            { 0, 1, 7 }, { 2, 6 }, { 1, 3 }, { 2, 4 } };

    public int knightDialer(int N) {
        int[][] dp = new int[2][10];
        // init
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                int count = 0;
                for (int prev : prevs[j]) {
                    count += dp[(i + 1) % 2][prev];
                    count %= MOD;
                }
                dp[i % 2][j] = count;
            }
        }
        int ans = 0;
        // sum to get the answer
        for (int i = 0; i < 10; i++) {
            ans += dp[(N - 1) % 2][i];
            ans %= MOD;
        }

        return ans;
    }
}

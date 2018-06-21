package com.zhangliang.leetcode;
/*
Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
*/

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= t.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = i;
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    dp[i][j]++;
                }
            }
        }

        return dp[s.length()][t.length()] < 2;
    }
}

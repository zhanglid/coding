package com.zhangliang.leetcode;
/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
*/

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s3.length() + 1][s1.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= s3.length(); i++) {
            dp[i][0] = (i - 1 < s2.length()) && dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= Math.min(i, s1.length()); j++) {
                dp[i][j] = dp[i - 1][j - 1] && s1.charAt(j - 1) == s3.charAt(i - 1)
                        || (i - j - 1 >= 0 && (i - j - 1) < s2.length()) && dp[i - 1][j] && s2.charAt(i - j - 1) == s3.charAt(i - 1);
            }
        }

        return dp[s3.length()][s1.length()];
    }
}

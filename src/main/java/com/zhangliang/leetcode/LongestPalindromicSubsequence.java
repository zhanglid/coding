package com.zhangliang.leetcode;
/*
Given a string s, find the longest palindromic subsequence's 
length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int size = 1; size <= s.length(); size++) {
            for (int i = 0; i + size - 1 < s.length(); i++) {
                char a = s.charAt(i);
                char b = s.charAt(i + size - 1);
                int j = i + size - 1;
                if (a == b && size > 1) {
                    dp[i][j] = 2 + (size > 2 ? dp[i + 1][j - 1] : 0);
                }
                dp[i][j] = Math.max(dp[i][j], size == 1 ? 1 : dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], size == 1 ? 1 : dp[i + 1][j]);
            }
        }
        return dp[0][s.length() - 1];
    }
}

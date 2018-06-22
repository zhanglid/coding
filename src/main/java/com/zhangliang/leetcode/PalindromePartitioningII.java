package com.zhangliang.leetcode;
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

*/

public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        boolean[][] isPalindromeDP = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                isPalindromeDP[i][j] = (s.charAt(i) == s.charAt(j)) && (i + 1 > j - 1 || isPalindromeDP[i + 1][j - 1]);
            }
        }

        int[] minCutDP = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            int ans = i - 1;
            for (int j = 0; j < i; j++) {
                if (isPalindromeDP[j][i - 1]) {
                    ans = Math.min(ans, minCutDP[j] + (j == 0 ? 0 : 1));
                }
            }
            minCutDP[i] = ans;
        }

        return minCutDP[s.length()];
    }
}

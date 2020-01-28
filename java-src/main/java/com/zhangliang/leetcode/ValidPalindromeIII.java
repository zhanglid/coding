package com.zhangliang.leetcode;
/*
Given a string s and an integer k, find out if the given string is a K-Palindrome or not.

A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from it.

Example 1:

Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.
 

Constraints:

1 <= s.length <= 1000
s has only lowercase English letters.
1 <= k <= s.length
*/

public class ValidPalindromeIII {
    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for (int size = 1; size <= s.length(); size++) {
            for (int i = 0; i + size - 1 < s.length(); i++) {
                int j = i + size - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1] <= k;
    }
}

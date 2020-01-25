package com.zhangliang.leetcode;

/*
Given a string, your task is to count how many palindromic substrings 
in this string.

The substrings with different start indexes or end indexes are counted 
as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000.
*/

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = len <= 2 || dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

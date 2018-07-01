package com.zhangliang.leetcode;
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int len = expand(s, i, i);
            if (len > ans.length()) {
                ans = s.substring(i - len / 2, i + len / 2 + 1);
            }
            len = expand(s, i, i + 1);
            if (len > ans.length()) {
                ans = s.substring(i - len / 2 + 1, i + len / 2 + 1);
            }
        }

        return ans;
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
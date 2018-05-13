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
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();

        int prev = 1;
        int max = 1;
        int[] interval = new int[2];
        boolean isSame = true;

        for (int i = 0; i < chars.length; i++) {
            int pairIndex = i - prev - 1;
            int pairIndexSecond = i - prev;
            int left = 0;
            if (pairIndex >= 0 && chars[pairIndex] == chars[i]) {
                prev += 2;
                left = pairIndex;
                isSame = isSame && chars[pairIndex + 1] == chars[i];
            } else if (isSame && pairIndexSecond >= 0 && chars[pairIndexSecond] == chars[i]) {
                prev += 1;
                left = pairIndexSecond;
            } else {
                prev = 1;
                isSame = true;
            }

            if (prev > max) {
                interval[0] = left;
                interval[1] = i;
                max = prev;
            }
        }

        return s.substring(interval[0], interval[1] + 1);

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome("cbbd"));
    }
}
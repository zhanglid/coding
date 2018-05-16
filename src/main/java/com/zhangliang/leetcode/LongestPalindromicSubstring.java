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
        int[] resultInterval = new int[2];

        for (int i = 0; i < chars.length; i++) {
            int[] ans1 = extendPalindrome(i, i, chars);
            int[] ans2 = extendPalindrome(i, i + 1, chars);

            if (ans1[1] - ans1[0] > resultInterval[1] - resultInterval[0]) {
                resultInterval[0] = ans1[0];
                resultInterval[1] = ans1[1];
            }

            if (ans2[1] - ans2[0] > resultInterval[1] - resultInterval[0]) {
                resultInterval[0] = ans2[0];
                resultInterval[1] = ans2[1];
            }
        }

        return s.substring(resultInterval[0], resultInterval[1] + 1);
    }

    private int[] extendPalindrome(int l, int r, char[] chars) {
        while(l >=0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }

        int[] ans = new int[2];
        ans[0] = l + 1;
        ans[1] = r - 1;

        return ans;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome("cbbd"));
    }
}
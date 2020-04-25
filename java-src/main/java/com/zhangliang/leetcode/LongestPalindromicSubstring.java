package com.zhangliang.leetcode;
/*
Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubstring {
    private int expand(int i, int j, String s) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return j - i + 1 - 2;
    }

    public String longestPalindrome(String s) {
        int[] sizes = new int[s.length() * 2];
        String ans = "";
        int pivot = 0;
        int right = 0;

        for (int i = 0; i < sizes.length; i++) {
            int l = i / 2;
            int r = i % 2 == 0 ? l : l + 1;
            int prevSize = i <= right ? sizes[pivot - (i - pivot)] : -1;
            if (prevSize > 0 && prevSize / 2 < (right - i) / 2) {
                sizes[i] = prevSize;
            } else {
                int size = expand(l, r, s);
                if (size > ans.length()) {
                    ans = s.substring(l - (size - 1) / 2, r + (size + 1) / 2);
                }
                int nextRight = i + size - 1;
                if (nextRight > right) {
                    pivot = i;
                    right = nextRight;
                }
                sizes[i] = size;
            }
        }

        return ans;
    }
}
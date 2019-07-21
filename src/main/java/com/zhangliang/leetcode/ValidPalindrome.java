package com.zhangliang.leetcode;
/*
Given a string, determine if it is a palindrome, considering only 
alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid 
palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

public class ValidPalindrome {
    private boolean isIgnoredChar(char x) {
        if (x >= 'A' && x <= 'Z') {
            return false;
        } else if (x >= 'a' && x <= 'z') {
            return false;
        } else if (x >= '0' && x <= '9') {
            return false;
        }
        return true;
    }

    private char normalize(char a) {
        if (a >= 'A' && a <= 'Z') {
            a += 'a' - 'A';
        }
        return a;
    }

    private boolean isSame(char a, char b) {
        return normalize(a) == normalize(b);
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (isIgnoredChar(s.charAt(l))) {
                l++;
            } else if (isIgnoredChar(s.charAt(r))) {
                r--;
            } else if (!isSame(s.charAt(l++), s.charAt(r--))) {
                return false;
            }
        }
        return true;
    }
}

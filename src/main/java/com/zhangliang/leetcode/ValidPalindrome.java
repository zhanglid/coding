package com.zhangliang.leetcode;
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

public class ValidPalindrome {

    private boolean isChar(char x) {
        return (x <= 'z' && x >= 'a') || (x <= 'Z' && x >= 'A');
    }

    private boolean isValidChar(char x) {
        if (isChar(x)) {
            return true;
        }

        if (x >= '0' && x <= '9') {
            return true;
        }
        return false;
    }

    private boolean isSame(char a, char b) {
        if (a == b) {
            return true;
        }

        if (isChar(a) && isChar(b)) {
            return Math.abs((int) a - b) == Math.abs('A' - 'a');
        }

        return false;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isValidChar(s.charAt(left))) {
                left++;
                continue;
            }

            if (!isValidChar(s.charAt(right))) {
                right--;
                continue;
            }

            if (!isSame(s.charAt(left), s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
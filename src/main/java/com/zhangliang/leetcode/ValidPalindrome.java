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
    private char ensureLowerCase(char a) {
        if (Character.isUpperCase(a)) {
            return (char) (a - 'A' + 'a');
        }
        return a;
    }

    private boolean shouldIgnore(char x) {
        return !Character.isAlphabetic(x) && !Character.isDigit(x);
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (shouldIgnore(s.charAt(i))) {
                i++;
            } else if (shouldIgnore(s.charAt(j))) {
                j--;
            } else if (ensureLowerCase(s.charAt(i)) != ensureLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}

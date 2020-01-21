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
    private boolean shouldIgnore(char x) {
        return !(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z' || x >= '0' && x <= '9');
    }

    private char toLowerCase(char x) {
        if (x >= 'a' && x <= 'z') {
            return x;
        }
        return (char) (x - 'A' + 'a');
    }

    private boolean isSame(char a, char b) {
        return toLowerCase(a) == toLowerCase(b);
    }

    public boolean isPalindrome(String s) {
        if (s.length() < 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (shouldIgnore(s.charAt(i))) {
                i++;
                continue;
            }
            if (shouldIgnore(s.charAt(j))) {
                j--;
                continue;
            }
            if (!isSame(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

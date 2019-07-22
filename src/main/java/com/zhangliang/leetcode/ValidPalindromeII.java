package com.zhangliang.leetcode;
/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a 
palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True

Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

public class ValidPalindromeII {
    private int[] valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        return new int[] { i, j };
    }

    private boolean isValidPoint(int[] point) {
        return point[0] >= point[1];
    }

    public boolean validPalindrome(String s) {
        int[] conflict = valid(s, 0, s.length() - 1);
        if (isValidPoint(conflict)) {
            return true;
        }
        return isValidPoint(valid(s, conflict[0] + 1, conflict[1]))
                || isValidPoint(valid(s, conflict[0], conflict[1] - 1));
    }
}

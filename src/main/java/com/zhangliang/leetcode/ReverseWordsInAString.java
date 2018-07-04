package com.zhangliang.leetcode;
/*
Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not 
contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
*/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            if (sb.length() > 0) {
                sb.append(' ');
            }

            sb.append(s.substring(j + 1, i + 1));
            i = j;
        }

        return sb.toString();
    }
}

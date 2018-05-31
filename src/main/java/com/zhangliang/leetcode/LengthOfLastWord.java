package com.zhangliang.leetcode;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int count = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char x = s.charAt(i);
            if (x == ' ') {
                if (flag) {
                    return count;
                }
            } else {
                flag = true;
                count++;
            }
        }

        return count;
    }
}

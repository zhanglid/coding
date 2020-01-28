package com.zhangliang.leetcode;
/*
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?


*/

public class ReverseWordsInAStringII {
    public void reverseWords(char[] str) {
        if (str == null || str.length < 1) {
            return;
        }

        int l = 0;
        int r = str.length - 1;
        while (l < r) {
            char t = str[l];
            str[l] = str[r];
            str[r] = t;
            l++;
            r--;
        }

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                continue;
            }
            int j = i;
            while (j < str.length && str[j] != ' ') {
                j++;
            }

            int lw = i;
            int rw = j - 1;
            while (lw < rw) {
                char t = str[lw];
                str[lw] = str[rw];
                str[rw] = t;
                lw++;
                rw--;
            }
            i = j - 1;
        }
    }
}

package com.zhangliang.leetcode;
/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle 
is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to 
ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. 
This is consistent to C's strstr() and Java's indexOf().
*/

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (haystack.equals("") && needle.equals("")) {
            return 0;
        }
        char[] charsA = haystack.toCharArray();
        char[] charsB = needle.toCharArray();
        for (int i = 0; i + charsB.length < charsA.length; i++) {
            boolean flag = true;
            for (int j = 0; i + j < charsA.length && j < charsB.length; j++) {
                if (charsA[i + j] != charsB[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr s = new ImplementStrStr();
        System.out.println(s.solve());
    }
}

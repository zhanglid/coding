package com.zhangliang.leetcode;
/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
*/

public class RegularExpressionMatching {

    private static boolean isCharMatch(char s, char p) {
        if (s == p) {
            return true;
        }

        else if (p == '.') {
            return true;
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];

        dp[0][0] = true;

        for (int i = 0; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {

                // case when coresponding pos chars are the same
                if (i - 1 >= 0 && isCharMatch(sChars[i - 1], pChars[j - 1])) {
                    if (dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                        continue;
                    }
                }

                // case meet *
                if (i != 0 && j >= 2 && pChars[j - 1] == '*') {
                    // char is equal to previous one
                    if (isCharMatch(sChars[i - 1], pChars[j - 2])) {
                        if (dp[i - 1][j - 1]) {
                            dp[i][j] = true;
                            continue;
                        }
                    }

                    // previos one is not useful, 0 match
                    if (j >= 2 && dp[i - 1][j - 2]) {
                        dp[i][j] = true;
                        continue;
                    }
                }
            }
        }

        return dp[lenS][lenP];
    }

    public static void main(String[] args) {
        RegularExpressionMatching s = new RegularExpressionMatching();
        System.out.println(s.isMatch("aab", "c*a*b"));
    }
}
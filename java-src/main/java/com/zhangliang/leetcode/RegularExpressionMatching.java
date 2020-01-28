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
    public boolean isMatch(String s, String p) {
        boolean[][] matches = new boolean[s.length() + 1][p.length() + 1];
        matches[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char pch = p.charAt(j - 1);
                if (i >= 1 && pch == s.charAt(i - 1) || pch == '.') {
                    if (i >= 0 && i > 0 && matches[i - 1][j - 1]) {
                        matches[i][j] = true;
                        continue;
                    }
                }
                if (pch == '*') {
                    if (i >= 1 && j > 1 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        if (i > 0 && matches[i - 1][j]) {
                            matches[i][j] = true;
                            continue;
                        }
                    }
                    if (j - 2 >= 0 && matches[i][j - 2]) {
                        matches[i][j] = true;
                    }
                }
            }
        }
        return matches[s.length()][p.length()];
    }
}
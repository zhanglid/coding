package com.zhangliang.leetcode;
/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching 
with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
*/

public class WildcardMatching {

    private boolean isSameChar(char a, char p) {
        if (p == '?') {
            return true;
        }
        return a == p;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return s.equals(p);
        }

        if (p.equals("*")) {
            return true;
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        boolean[][] dp = new boolean[sChars.length + 1][pChars.length + 1];

        dp[0][0] = true;

        for (int i = 0; i <= sChars.length; i++) {
            for (int j = 0; j <= pChars.length; j++) {
                if (i > 0 && j > 0 && isSameChar(sChars[i - 1], pChars[j - 1])) {
                    if (dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }

                if (j > 0 && pChars[j - 1] == '*') {
                    if (i > 0 && dp[i - 1][j] || j > 0 && dp[i][j - 1]) {
                        dp[i][j] = true;
                    }

                    if (i > 0 && j > 0 && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[sChars.length][pChars.length];
    }
}

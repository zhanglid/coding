package com.zhangliang.leetcode;
/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some 
(can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
*/

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                dp[j][i] = dp[j - 1][i] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[j - 1][i - 1] : 0);
            }
        }

        return dp[s.length()][t.length()];
    }
}

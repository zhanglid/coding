package com.zhangliang.leetcode;
/*
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
*/

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= i && j <= T.length(); j++) {
                char a = S.charAt(i - 1);
                char b = T.charAt(j - 1);
                if (a == b) {
                    if (dp[i - 1][j - 1] > 0 || j == 1) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    if (dp[i - 1][j] > 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
            }
        }
        String result = null;
        for (int i = T.length(); i <= S.length(); i++) {
            int val = dp[i][T.length()];
            if (val > 0 && (result == null || val < result.length())) {
                result = S.substring(i - val, i);
            }
        }
        return result == null ? "" : result;
    }

}

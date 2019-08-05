package com.zhangliang.leetcode;
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int num = 0;
            if (s.charAt(i) != '0') {
                num += dp[(i - 1) % 2];
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                num += i - 2 >= 0 ? dp[(i - 2) % 2] : 1;
            }
            dp[i % 2] = num;
        }
        return dp[(s.length() - 1) % 2];
    }
}

package com.zhangliang.leetcode;
/*
Given a string S, find the number of different non-empty palindromic 
subsequences in S, and return that number modulo 10^9 + 7.

A subsequence of a string S is obtained by deleting 0 or more characters from S.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i 
for which A_i != B_i.

Example 1:
Input: 
S = 'bccb'
Output: 6
Explanation: 
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 
'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.

Example 2:
Input: 
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
Output: 104860361
Explanation: 
There are 3104860382 different non-empty palindromic subsequences, which is 
104860361 modulo 10^9 + 7.

Note:

The length of S will be in the range [1, 1000].
Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
*/

import java.util.*;

public class CountDifferentPalindromicSubsequences {
    static int MOD = 1_000_000_000 + 7;
    static char[] CHARS = { 'a', 'b', 'c', 'd' };
    private Map<String, Integer> cache = new HashMap<>();

    public int countPalindromicSubsequences(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        int result = 0;
        for (char ch : CHARS) {
            int l = s.indexOf(ch);
            int r = s.lastIndexOf(ch);
            if (l < 0 || r < 0) {
                continue;
            }
            // self
            int count = 1;
            // pair
            if (l < r) {
                count++;
            }
            if (l + 1 < r) {
                // as wrapper
                count += countPalindromicSubsequences(s.substring(l + 1, r));
            }
            result += count;
            result %= MOD;
        }
        cache.put(s, result);
        return result;
    }
}

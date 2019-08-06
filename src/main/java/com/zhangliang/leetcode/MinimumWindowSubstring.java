package com.zhangliang.leetcode;
/*
Given a string S and a string T, find the minimum window in S which will 
contain all the characters in T in 
complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return 
the empty string "". If there is such window, you are guaranteed that 
there will always be only one unique minimum window in S.
*/

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String ans = null;
        int[] counts = new int[256];
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i)]++;
        }
        int resolvedCount = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i)] > 0) {
                resolvedCount++;
            }
            counts[s.charAt(i)]--;
            if (resolvedCount == t.length()) {
                while (resolvedCount == t.length()) {
                    if (counts[s.charAt(l)] >= 0) {
                        resolvedCount--;
                    }
                    counts[s.charAt(l)]++;
                    l++;
                }
                if (ans == null || (i - (l - 1) + 1) < ans.length()) {
                    ans = s.substring(l - 1, i + 1);
                }
            }
        }

        return ans == null ? "" : ans;
    }
}

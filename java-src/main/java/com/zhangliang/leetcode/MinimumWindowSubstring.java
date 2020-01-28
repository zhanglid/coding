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
        int[] counts = new int[256];
        for (char x : t.toCharArray()) {
            counts[x]++;
        }
        int count = 0;
        int l = 0;
        String result = null;
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]--;
            if (counts[s.charAt(i)] >= 0) {
                count++;
            }
            if (count == t.length()) {
                while (count == t.length()) {
                    counts[s.charAt(l)]++;
                    if (counts[s.charAt(l)] > 0) {
                        count--;
                    }
                    l++;
                }
                if (result == null || (i - l + 2) < result.length()) {
                    result = s.substring(l - 1, i + 1);
                }
            }
        }
        return result == null ? "" : result;
    }
}

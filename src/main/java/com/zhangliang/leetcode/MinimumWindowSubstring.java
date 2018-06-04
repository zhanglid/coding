package com.zhangliang.leetcode;
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in 
complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        int[] counters = new int[256];
        int count = t.length();
        for (char x : t.toCharArray()) {
            counters[x]++;
        }

        int l = 0;
        String ans = s;
        for (int i = 0; i < s.length(); i++) {
            counters[s.charAt(i)]--;
            if (counters[s.charAt(i)] >= 0) {
                count--;
            }

            if (count == 0) {
                while (counters[s.charAt(l)] != 0) {
                    counters[s.charAt(l)]++;
                    l++;
                }
                if (ans.length() > i - l + 1)
                    ans = s.substring(l, i + 1);
            }
        }

        return ans;
    }
}

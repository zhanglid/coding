package com.zhangliang.leetcode;
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        boolean[] map = new boolean[26];

        int l = 0;
        int r = 0;
        int ans = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (map[c - 'a']) {
                while(s.charAt(l) != c) {
                    map[s.charAt(l) - 'a'] = false;
                    l++;
                }
                l++;
            }
            map[c - 'a'] = true;
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
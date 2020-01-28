package com.zhangliang.leetcode;
/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] counts = new int[256];
        int ans = 0;
        int count = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i)] == 0) {
                count++;
            }
            counts[s.charAt(i)]++;
            while (count > k) {
                counts[s.charAt(l)]--;
                if (counts[s.charAt(l)] == 0) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}

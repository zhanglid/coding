package com.zhangliang.leetcode;
/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

*/

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int[] counter = new int[256];
        int num = 0;
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i)] == 0) {
                num++;
            }
            counter[s.charAt(i)]++;
            while (num > 2) {
                if (counter[s.charAt(left)] == 1) {
                    num--;
                }
                counter[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}

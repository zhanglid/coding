package com.zhangliang.leetcode;
/*
Given a string S, check if the letters can be rearranged so that two characters that are 
adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"

Example 2:
Input: S = "aaab"
Output: ""

Note:
S will consist of lowercase letters and have length in range [1, 500].
*/

public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        for (char x : S.toCharArray()) {
            counts[x - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < S.length()) {
            char prev = sb.length() < 1 ? 0 : sb.charAt(sb.length() - 1);
            char target = 0;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0 && i + 'a' != prev && (target == 0 || counts[i] > counts[target - 'a'])) {
                    target = (char) (i + 'a');
                }
            }
            if (target == 0) {
                return "";
            }
            sb.append(target);
            counts[target - 'a']--;
        }
        return sb.toString();
    }
}

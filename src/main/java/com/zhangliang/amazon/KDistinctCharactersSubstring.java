package com.zhangliang.amazon;
/*
Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that has exactly k distinct characters.
Examples:

Input: abc, k = 2
Output: 2
Possible substrings are {"ab", "bc"}

Input: aba, k = 2
Output: 3
Possible substrings are {"ab", "ba", "aba"}

Input: aa, k = 1
Output: 3
Possible substrings are {"a", "a", "aa"}
*/

public class KDistinctCharactersSubstring {
    static public int countkDist(String str, int k) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] counters = new int[26];
            int distinctCount = 0;
            for (int j = i; j < str.length() && distinctCount <= k; j++) {
                counters[str.charAt(j) - 'a']++;
                if (counters[str.charAt(j) - 'a'] == 1) {
                    distinctCount++;
                }
                if (distinctCount == k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}

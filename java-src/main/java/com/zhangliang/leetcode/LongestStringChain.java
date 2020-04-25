package com.zhangliang.leetcode;
/*
Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  
For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is 
a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

Example 1:

Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".
 

Note:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.
*/

import java.util.*;

public class LongestStringChain {
    private boolean isPredecessor(String pre, String word) {
        if (pre.length() != word.length() - 1) {
            return false;
        }
        if (pre.length() == 0) {
            return true;
        }
        boolean findInsertedChar = false;
        int l = 0;
        for (int i = 0; i < pre.length(); i++) {
            if (pre.charAt(i) != word.charAt(l)) {
                if (findInsertedChar) {
                    return false;
                }
                findInsertedChar = true;
                i--;
            }
            l++;
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        int[] dp = new int[words.length];
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            int len = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (isPredecessor(words[j], words[i])) {
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}

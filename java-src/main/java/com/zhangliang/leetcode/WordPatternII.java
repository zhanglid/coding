package com.zhangliang.leetcode;
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between 
a letter in pattern and a non-empty substring in str.

Example 1:

Input: pattern = "abab", str = "redblueredblue"
Output: true

Example 2:

Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
Output: true

Example 3:

Input: pattern = "aabb", str = "xyzabcxzyabc"
Output: false
Notes:
You may assume both pattern and str contains only lowercase letters.
*/

import java.util.*;

public class WordPatternII {
    private boolean dfs(Map<Character, String> patterns, Map<String, Character> inversedPatterns, String pattern,
            String str, int index, int strIndex) {
        if (index >= pattern.length()) {
            // We have matched all patterns.
            return strIndex == str.length();
        }
        if (strIndex >= str.length()) {
            return false;
        }
        char ch = pattern.charAt(index);
        if (patterns.containsKey(ch)) {
            // Already has the pattern
            String part = patterns.get(ch);
            if (!str.substring(strIndex, Math.min(strIndex + part.length(), str.length())).equals(part)) {
                return false;
            }
            return dfs(patterns, inversedPatterns, pattern, str, index + 1, strIndex + part.length());
        } else {
            // Look for new pattern
            for (int i = strIndex; i < str.length(); i++) {
                String part = str.substring(strIndex, i + 1);
                if (!inversedPatterns.containsKey(part)) {
                    patterns.put(ch, part);
                    inversedPatterns.put(part, ch);
                    if (dfs(patterns, inversedPatterns, pattern, str, index + 1, i + 1)) {
                        return true;
                    }
                    patterns.remove(ch);
                    inversedPatterns.remove(part);
                }
            }
        }
        return false;
    }

    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(new HashMap<>(), new HashMap<>(), pattern, str, 0, 0);
    }
}

package com.zhangliang.leetcode;
/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.

*/

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return s == t;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reversedMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a) && map.get(a) != b || reversedMap.containsKey(b) && reversedMap.get(b) != a) {
                return false;
            }
            map.put(a, b);
            reversedMap.put(b, a);
        }

        return true;
    }
}

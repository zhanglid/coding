package com.zhangliang.leetcode;
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

import java.util.*;

public class GroupAnagrams {
    private String hash(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            String h = hash(s);
            if (!groups.containsKey(h)) {
                groups.put(h, new ArrayList<>());
            }
            groups.get(h).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}

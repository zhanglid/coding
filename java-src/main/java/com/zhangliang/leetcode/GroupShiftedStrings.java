package com.zhangliang.leetcode;
/*
Given a string, we can "shift" each of its letter to its successive 
letter, for example: "abc" -> "bcd". We can keep "shifting" which forms 
the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group 
all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/

import java.util.*;

public class GroupShiftedStrings {
    private String hash(String str) {
        if (str.length() < 1) {
            return "";
        }
        int diff = str.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char x = (char) (str.charAt(i) - diff);
            if (x < 'a') {
                x += 26;
            }
            sb.append(x);
        }
        return sb.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strings) {
            String hashCode = hash(s);
            if (!groups.containsKey(hashCode)) {
                groups.put(hashCode, new ArrayList<>());
            }
            groups.get(hashCode).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}

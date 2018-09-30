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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    private String hash(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char head = s.charAt(0);
        for (char x : s.toCharArray()) {
            char t = (char)( x + 'a' - head );
            if (t < 'a') {
                t += 26;
            }
            sb.append((char)(t));
        }
        return sb.toString();
    }
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        if (strings == null || strings.length < 1) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = hash(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        for (List<String> part : map.values()) {
            ans.add(part);
        }

        return ans;
    }
}

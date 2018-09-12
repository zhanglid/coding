package com.zhangliang.leetcode;
/*
There is a new alien language which uses the latin alphabet. However, the order 
among letters are unknown to you. You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. Derive the order 
of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length < 1) {
            return "";
        }

        Map<Character, Set<Character>> neighbors = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (char x : words[i].toCharArray()) {
                if (!neighbors.containsKey(x)) {
                    neighbors.put(x, new HashSet<>());
                }
            }

            if (i > 0) {
                int j = 0;
                int len = Math.min(words[i].length(), words[i - 1].length());
                for (; j < len; j++) {
                    if (words[i].charAt(j) != words[i - 1].charAt(j)) {
                        break;
                    }
                }
                if (j == len) {
                    continue;
                }
                neighbors.get(words[i - 1].charAt(j)).add(words[i].charAt(j));
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        for (char x : neighbors.keySet()) {
            if (!helper(x, visited, sb, new HashSet<>(), neighbors)) {
                sb.delete(0, sb.length());
                break;
            }
        }

        sb.reverse();

        return sb.toString();
    }

    private boolean helper(Character c, Set<Character> visited, StringBuilder sb, Set<Character> path,
            Map<Character, Set<Character>> neighbors) {
        if (path.contains(c)) {
            return false;
        }
        if (visited.contains(c)) {
            return true;
        }
        path.add(c);
        visited.add(c);
        for (char x : neighbors.get(c)) {
            if (!helper(x, visited, sb, path, neighbors)) {
                return false;
            }
        }

        sb.append(c);
        path.remove(c);
        return true;
    }
}

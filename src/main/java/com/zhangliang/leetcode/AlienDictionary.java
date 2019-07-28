package com.zhangliang.leetcode;
/*
There is a new alien language which uses the latin alphabet. However, the order 
among letters are unknown to you. You receive a list of non-empty words from the 
dictionary, where words are sorted lexicographically by the rules of this new 
language. Derive the order of letters in this language.

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

import java.util.*;

public class AlienDictionary {
    private int toInt(char x) {
        return x - 'a';
    }

    private List<Character> topoSort(boolean[][] graph) {
        Set<Character> visited = new HashSet<>();
        List<Character> ans = new LinkedList<>();
        for (char x = 'a'; x <= 'z'; x++) {
            if (visited.contains(x)) {
                continue;
            }
            Set<Character> path = new HashSet<>();
            List<Character> pathList = topoSortHelper(graph, x, visited, path);
            if (pathList == null) {
                return null;
            }
            visited.addAll(pathList);
            pathList.addAll(ans);
            ans = pathList;
        }
        return ans;
    }

    private List<Character> topoSortHelper(boolean[][] graph, char ch, Set<Character> visited, Set<Character> path) {
        List<Character> ans = new LinkedList<>();
        if (visited.contains(ch) || !graph[toInt(ch)][toInt(ch)]) {
            return ans;
        }
        if (path.contains(ch)) {
            return null;
        }
        ans.add(ch);
        path.add(ch);
        for (char other = 'a'; other <= 'z'; other++) {
            if (graph[toInt(ch)][toInt(other)] && other != ch) {
                List<Character> rest = topoSortHelper(graph, other, visited, path);
                if (rest == null) {
                    return null;
                }
                visited.addAll(rest);
                ans.addAll(rest);
            }
        }
        path.remove(ch);
        return ans;
    }

    /**
     * Build the graph from string.
     */
    private boolean[][] buildGraph(String[] words) {
        boolean[][] graph = new boolean[26][26];
        String prev = "";
        for (String word : words) {
            boolean diff = false;
            for (int i = 0; i < word.length(); i++) {
                // set self -> self to true to indicate a char exists
                graph[toInt(word.charAt(i))][toInt(word.charAt(i))] = true;
                // prev has char
                if (i < prev.length()) {
                    if (prev.charAt(i) == word.charAt(i)) {
                        continue;
                    }
                    if (!diff) {
                        diff = true;
                        graph[toInt(prev.charAt(i))][toInt(word.charAt(i))] = true;
                    }
                }
            }
            prev = word;
        }
        return graph;
    }

    public String alienOrder(String[] words) {
        boolean[][] graph = buildGraph(words);
        List<Character> ans = topoSort(graph);
        if (ans == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : ans) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

package com.zhangliang.leetcode;
/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest 
transformation sequence(s) 
from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

import java.util.*;

public class WordLadderII {
    private void bfs(String start, String end, Set<String> words, Map<String, Integer> distances) {
        int distance = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        distances.put(start, 0);
        while (!queue.isEmpty() && !distances.containsKey(end)) {
            distance++;
            int size = queue.size();
            for (int t = 0; t < size; t++) {
                String word = queue.poll();
                StringBuilder sb = new StringBuilder(word);
                for (int i = 0; i < sb.length(); i++) {
                    char x = sb.charAt(i);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != x) {
                            sb.setCharAt(i, ch);
                            String key = sb.toString();
                            if (words.contains(key) && !distances.containsKey(key)) {
                                distances.put(key, distance);
                                queue.add(key);
                            }
                        }
                    }
                    sb.setCharAt(i, x);
                }
            }
        }
    }

    private void build(String start, List<String> path, Set<String> words, Map<String, Integer> distances,
            List<List<String>> result) {
        String first = path.get(0);
        int distance = distances.get(first);
        if (distance == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder(first);
        for (int i = 0; i < first.length(); i++) {
            char x = sb.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != x) {
                    sb.setCharAt(i, ch);
                    String key = sb.toString();
                    if ((words.contains(key) || start.equals(key)) && distances.containsKey(key)
                            && distances.get(key) == distance - 1) {
                        path.add(0, key);
                        build(start, path, words, distances, result);
                        path.remove(0);
                    }
                }
            }
            sb.setCharAt(i, x);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Map<String, Integer> distances = new HashMap<>();
        bfs(beginWord, endWord, set, distances);
        if (!distances.containsKey(endWord)) {
            return ans;
        }
        build(beginWord, new ArrayList<>(Arrays.asList(endWord)), set, distances, ans);
        return ans;
    }
}

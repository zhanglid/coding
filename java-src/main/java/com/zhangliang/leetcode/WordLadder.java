package com.zhangliang.leetcode;
/*
Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation 
sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is 
not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is 
"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible 
transformation.
*/

import java.util.*;

public class WordLadder {
    private int bfs(String start, Set<String> words, String end) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int distance = 1;
        while (!queue.isEmpty() && !visited.contains(end)) {
            distance++;
            int size = queue.size();
            for (int t = 0; t < size; t++) {
                String node = queue.poll();
                StringBuilder sb = new StringBuilder(node);
                for (int i = 0; i < sb.length(); i++) {
                    char x = sb.charAt(i);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != x) {
                            sb.setCharAt(i, ch);
                            String key = sb.toString();
                            if (visited.contains(key) || !words.contains(key)) {
                                continue;
                            }
                            visited.add(key);
                            queue.add(key);
                        }
                    }
                    sb.setCharAt(i, x);
                }
            }
        }

        return visited.contains(end) ? distance : 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        return bfs(beginWord, dict, endWord);
    }
}

package com.zhangliang.leetcode;
/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation 
sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
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

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || beginWord == null || endWord == null) {
            return 0;
        }
        Set<String> wordsSet = new HashSet<>(wordList);
        Set<String> achievedSet = new HashSet<>();
        achievedSet.add(beginWord);
        int count = 1;
        while (!achievedSet.contains(endWord)) {
            if (achievedSet.isEmpty()) {
                return 0;
            }
            Set<String> nextSet = new HashSet<>();
            for (String s : achievedSet) {
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < sb.length(); i++) {
                    char curChar = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == curChar) {
                            continue;
                        }

                        sb.setCharAt(i, c);

                        String choice = sb.toString();
                        if (wordsSet.contains(choice)) {
                            nextSet.add(choice);
                            wordsSet.remove(choice);
                        }
                    }
                    sb.setCharAt(i, curChar);
                }
            }
            achievedSet = nextSet;
            count++;
        }

        return count;
    }
}

package com.zhangliang.leetcode;
/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words 
word1 and word2 and return the shortest distance between these two words in the list. Your method will be called 
repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

import java.util.*;

public class ShortestWordDistanceII {
    static class WordDistance {
        Map<String, List<Integer>> indexesByWord = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (!indexesByWord.containsKey(words[i])) {
                    indexesByWord.put(words[i], new ArrayList<>());
                }
                indexesByWord.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            if (!indexesByWord.containsKey(word1) || !indexesByWord.containsKey(word2)) {
                return -1;
            }
            List<Integer> word1IndexList = indexesByWord.get(word1);
            List<Integer> word2IndexList = indexesByWord.get(word2);
            int i = 0;
            int j = 0;
            int value = Integer.MAX_VALUE;
            while (i < word1IndexList.size() && j < word2IndexList.size()) {
                value = Math.min(value, Math.abs(word1IndexList.get(i) - word2IndexList.get(j)));
                if (word1IndexList.get(i) < word2IndexList.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return value;
        }
    }
}

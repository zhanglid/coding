package com.zhangliang.leetcode;
/*
Given a list of words and two words word1 and word2, return the shortest 
distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words 
in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.
*/

import java.util.*;

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, Integer> lastPosition = new HashMap<>();
        int ans = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && lastPosition.containsKey(word2)) {
                ans = Math.min(ans, i - lastPosition.get(word2));
            }
            if (words[i].equals(word2) && lastPosition.containsKey(word1)) {
                ans = Math.min(ans, i - lastPosition.get(word1));
            }
            lastPosition.put(words[i], i);
        }
        return ans;
    }
}

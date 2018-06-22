package com.zhangliang.leetcode;
/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) 
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null) {
            return ans;
        }

        Map<String, Integer> distDict = new HashMap<>();
        for (String string : wordList) {
            distDict.put(string, -1);
        }
        distDict.put(beginWord, 0);

        if (!distDict.containsKey(endWord)) {
            return ans;
        }

        calculateDist(beginWord, endWord, distDict);

        if (distDict.get(endWord) < 0) {
            return ans;
        }
        generatePaths(beginWord, endWord, distDict, ans);

        return ans;
    }

    private void generatePaths(String beginWord, String endWord, Map<String, Integer> distDict,
            List<List<String>> ans) {
        List<String> cur = new ArrayList<>();
        cur.add(endWord);
        ans.add(cur);
        int curDist = distDict.get(endWord);
        while (curDist >= 0) {
            List<List<String>> additionalLists = new ArrayList<>();
            for (List<String> list : ans) {
                String sCur = list.get(0);
                boolean hasGotOne = false;
                StringBuilder sb = new StringBuilder(sCur);
                for (int i = 0; i < sb.length(); i++) {
                    char t = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == t) {
                            continue;
                        }

                        sb.setCharAt(i, c);
                        String key = sb.toString();
                        if (distDict.containsKey(key) && distDict.get(key) == curDist - 1) {
                            if (!hasGotOne) {
                                list.add(0, key);
                                hasGotOne = true;
                            } else {
                                List<String> newList = new ArrayList<>(list);
                                newList.set(0, key);
                                additionalLists.add(newList);
                            }
                        }
                    }
                    sb.setCharAt(i, t);
                }
            }
            ans.addAll(additionalLists);
            curDist--;
        }
    }

    private void calculateDist(String beginWord, String endWord, Map<String, Integer> distDict) {
        Set<String> wordsSet = new HashSet<>();
        wordsSet.add(beginWord);
        int count = 0;
        while (!wordsSet.isEmpty() && !wordsSet.contains(endWord)) {
            Set<String> nextSet = new HashSet<>();
            count++;
            for (String word : wordsSet) {
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    char x = word.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (x == c) {
                            continue;
                        }
                        sb.setCharAt(i, c);
                        String key = sb.toString();
                        if (distDict.containsKey(key) && distDict.get(key) == -1) {
                            nextSet.add(key);
                            distDict.put(key, count);
                        }
                    }
                }
            }
            wordsSet = nextSet;
        }
    }
}

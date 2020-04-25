package com.zhangliang.leetcode;
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a 
sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

import java.util.*;

public class WordBreakII {
  private Map<Integer, List<List<String>>> cache = new HashMap<>();

  private List<List<String>> helper(String s, int size, Set<String> dict) {
    if (cache.containsKey(size)) {
      return cache.get(size);
    }
    List<List<String>> result = new ArrayList<>();
    for (int i = size - 1; i >= 0; i--) {
      String last = s.substring(i, size);
      if (dict.contains(last)) {
        List<List<String>> rests = helper(s, i, dict);
        for (List<String> rest : rests) {
          List<String> path = new ArrayList<>(rest);
          path.add(last);
          result.add(path);
        }
      }
    }

    cache.put(size, result);
    return result;
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    cache.put(0, new ArrayList<>());
    cache.get(0).add(new ArrayList<>());
    Set<String> dict = new HashSet<>(wordDict);
    List<List<String>> result = helper(s, s.length(), dict);
    List<String> ans = new ArrayList<>();
    for (List<String> path : result) {
      ans.add(String.join(" ", path));
    }
    return ans;
  }
}

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    private Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if (s == null || wordDict == null) {
            return ans;
        }
        Set<String> set = new HashSet<>();
        for (String string : wordDict) {
            set.add(string);
        }
        cache.put("", Arrays.asList(""));
        return helper(s, set);
    }

    private List<String> helper(String s, Set<String> set) {
        if (cache.containsKey(s) || s.isEmpty()) {
            return new ArrayList<>(cache.get(s));
        }

        List<String> ans = new ArrayList<>();
        StringBuilder nextBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            nextBuilder.append(s.charAt(i));
            String next = nextBuilder.toString();
            if (set.contains(next)) {
                List<String> rest = helper(s.substring(i + 1), set);
                for (int j = 0; j < rest.size(); j++) {
                    if (rest.get(j).length() > 0) {
                        rest.set(j, next + " " + rest.get(j));
                    } else {
                        rest.set(j, next);
                    }
                }
                ans.addAll(rest);
            }
        }

        cache.put(s, new ArrayList<>(ans));
        return ans;
    }
}

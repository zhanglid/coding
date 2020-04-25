package com.zhangliang.leetcode;
/*
You are given a string, s, and a list of words, words, that are all of the same 
length. Find all starting indices of substring(s) in s that is a concatenation 
of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" 
respectively.
The output order does not matter, returning [9,0] is fine too.


Example 2:

Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null || words.length < 1 || s.length() < words[0].length()) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i + 1);
        }
        int targetSum = 0;
        for (String word : words) {
            targetSum += map.get(word);
        }
        int step = words[0].length();
        for (int offset = 0; offset < step; offset++) {
            int len = (s.length() - offset) / step;
            int[] sums = new int[len];
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int index = offset + i * step;
                sum += map.getOrDefault(s.substring(index, index + step), targetSum + 1);
                sums[i] = sum;
                if (i + 1 > words.length) {
                    if (sum - sums[i - words.length] == targetSum) {
                        ans.add(offset + (i - words.length + 1) * step);
                    }
                }
                else if (i + 1 == words.length) {
                    if (sum == targetSum) {
                        ans.add(offset);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        System.out.println(s.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
    }
}

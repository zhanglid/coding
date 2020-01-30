package com.zhangliang.leetcode;
/*
You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
 

Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20
*/

import java.util.*;

public class FindAndReplacePattern {
    private boolean checkPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reversedMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = pattern.charAt(i);

            if (map.containsKey(a) && map.get(a) != b || reversedMap.containsKey(b) && reversedMap.get(b) != a) {
                return false;
            }

            map.put(a, b);
            reversedMap.put(b, a);
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (checkPattern(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }
}

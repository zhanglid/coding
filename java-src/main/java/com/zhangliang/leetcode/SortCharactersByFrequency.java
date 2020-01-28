package com.zhangliang.leetcode;
/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

import java.util.*;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> keys = new ArrayList<>(freqMap.keySet());

        Collections.sort(keys, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return freqMap.get(b) - freqMap.get(a);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Character key : keys) {
            for (int i = 0; i < freqMap.get(key); i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}

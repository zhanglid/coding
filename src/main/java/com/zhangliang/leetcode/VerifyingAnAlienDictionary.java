package com.zhangliang.leetcode;
/*
In an alien language, surprisingly they also use english lowercase letters, 
but possibly in a different order. The order of the alphabet is some 
permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of 
the alphabet, return true if and only if the given words are sorted 
lexicographicaly in this alien language.

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence 
is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then 
words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string 
is shorter (in size.) According to lexicographical rules "apple" > "app", 
because 'l' > '∅', where '∅' is defined as the blank character which is 
less than any other character (More info).

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.

*/

import java.util.Comparator;

public class VerifyingAnAlienDictionary {

    private Comparator<String> getComparator(int[] order) {
        return new Comparator<String>() {
            public int compare(String a, String b) {
                int i = 0;
                for (; i < a.length() && i < b.length(); i++) {
                    char ac = a.charAt(i);
                    char bc = b.charAt(i);

                    if (order[ac - 'a'] < order[bc - 'a']) {
                        return -1;
                    } else if (order[ac - 'a'] > order[bc - 'a']) {
                        return 1;
                    }
                }

                if (i < a.length()) {
                    return 1;
                }
                if (i < b.length()) {
                    return -1;
                }
                return 0;
            }
        };
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < 26; i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        Comparator<String> comparator = getComparator(orderMap);
        for (int i = 1; i < words.length; i++) {
            if (comparator.compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}

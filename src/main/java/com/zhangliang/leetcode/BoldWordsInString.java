package com.zhangliang.leetcode;
/*
Given a set of keywords words and a string S, make all appearances of all keywords in S 
bold. Any letters between <b> and </b> tags become bold.

The returned string should use the least number of tags possible, and of course the tags 
should form a valid combination.

For example, given that words = ["ab", "bc"] and S = "aabcd", we should return 
"a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is 
incorrect.

Note:
words has length in range [0, 50].
words[i] has length in range [1, 10].
S has length in range [0, 500].
All characters in words[i] and S are lowercase letters.

*/

import java.util.*;

public class BoldWordsInString {
    public String boldWords(String[] words, String S) {
        boolean[] boldStatuses = new boolean[S.length()];
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word);
        }
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                String s = S.substring(i, j);
                if (wordsSet.contains(s)) {
                    Arrays.fill(boldStatuses, i, j, true);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int l = 0;
        for (int i = 1; i <= boldStatuses.length; i++) {
            if (i == boldStatuses.length || boldStatuses[i] != boldStatuses[l]) {
                String s = S.substring(l, i);
                if (boldStatuses[l]) {
                    sb.append("<b>" + s + "</b>");
                } else {
                    sb.append(s);
                }
                l = i;
            }
        }
        return sb.toString();
    }
}

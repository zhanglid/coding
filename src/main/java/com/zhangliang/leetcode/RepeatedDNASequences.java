package com.zhangliang.leetcode;
/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, 
and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences 
within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) 
that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
*/

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(s.substring(0, 10));
        set.add(sb.toString());
        for (int i = 10; i < s.length(); i++) {
            sb.delete(0, 1);
            sb.append(s.charAt(i));
            String key = sb.toString();
            if (set.contains(key)) {
                result.add(key);
            }
            set.add(key);
        }
        return new ArrayList<>(result);
    }
}

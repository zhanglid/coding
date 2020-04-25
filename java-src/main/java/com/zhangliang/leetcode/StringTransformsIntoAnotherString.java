package com.zhangliang.leetcode;
/*
Given two strings str1 and str2 of the same length, determine whether 
you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in 
str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2.

Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. 
Note that the order of conversions matter.

Example 2:

Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.

Note:

1 <= str1.length == str2.length <= 10^4
Both str1 and str2 contain only lowercase English letters.
*/

/*
## Analysis

aabcc -> ccdee

             
aabcc a->c ccbcc mixed c  ---- not work

1. b->d: aa(b)cc -> aa(d)cc
2. c->e: aad(cc) -> aad(ee)
3. a->c: (aa)dee -> (cc)dee !

Changes should be in an order.
*/

import java.util.*;

public class StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        // Base case
        if (str1 == null || str2 == null) {
            return str1 == str2;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }

        // Build the graph, and check mapping.
        char[] mapping = new char[256]; // For simplicity, we use 256.
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char a = str1.charAt(i);
            char b = str2.charAt(i);

            if (mapping[a] != 0 && mapping[a] != b) {
                return false;
            }
            mapping[a] = b;

            if (!graph.containsKey(b)) {
                graph.put(b, new HashSet<>());
            }
            graph.get(b).add(a);
        }
        return graph.size() != 26;
    }
}

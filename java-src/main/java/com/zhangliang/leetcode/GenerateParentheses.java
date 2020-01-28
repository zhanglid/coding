package com.zhangliang.leetcode;
/*
Given n pairs of parentheses, write a function to generate 
all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<Set<String>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        dp.get(0).add("");
        for (int i = 1; i <= n; i++) {
            Set<String> solutionSet = new HashSet<>();
            for (int j = 0; j < i; j++) {
                for (String left : dp.get(j)) {
                    for (String right : dp.get(i - j - 1)) {
                        solutionSet.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(solutionSet);
        }
        return new ArrayList<>(dp.get(n));
    }
}
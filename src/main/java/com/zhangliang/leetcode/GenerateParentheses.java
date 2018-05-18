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

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }

        List<List<String>> dp = new ArrayList<>();
        dp.add(new ArrayList<String>());
        dp.get(0).add("");

        for (int i = 1; i <= n; i++) {
            List<String> record = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String sIn: dp.get(j)) {
                    for (String sOut: dp.get(i - 1 - j)) {
                        record.add(sOut + "(" + sIn + ")");
                    }
                }
            }
            dp.add(record);
        }

        return dp.get(n);
    }

    public static void main(String[] args) {
        GenerateParentheses s = new GenerateParentheses();
        System.out.println(s.generateParenthesis(3));
    }
}
package com.zhangliang.leetcode;
/*
Given a string that contains only digits 0-9 and a target value, 
return all possibilities to add binary operators (not unary) +, -, 
or * between the digits so they evaluate to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:
Input: num = "3456237490", target = 9191
Output: []
*/

import java.util.*;

public class ExpressionAddOperators {
    private void evalDfs(String cur, int sum, int last, List<Integer> numList, int start, int target,
            List<String> result) {
        if (start == numList.size()) {
            if (sum + last == target) {
                result.add(cur);
            }
            return;
        }
        int num = numList.get(start);
        evalDfs(cur + "+" + num, sum + last, num, numList, start + 1, target, result);
        evalDfs(cur + "-" + num, sum + last, -num, numList, start + 1, target, result);
        evalDfs(cur + "*" + num, sum, last * num, numList, start + 1, target, result);
    }

    private void numDfs(List<Integer> cur, int start, String s, List<String> result, int target) {
        if (start == s.length()) {
            if (!cur.isEmpty()) {
                evalDfs(cur.get(0).toString(), 0, cur.get(0), cur, 1, target, result);
            }
            return;
        }
        int val = 0;
        for (int i = start; i < s.length() && (i == start || val != 0); i++) {
            int next = 10 * val + s.charAt(i) - '0';
            if (next / 10 != val) {
                break;
            }
            val = next;
            cur.add(val);
            numDfs(cur, i + 1, s, result, target);
            cur.remove(cur.size() - 1);
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        numDfs(new ArrayList<>(), 0, num, result, target);
        return result;
    }
}

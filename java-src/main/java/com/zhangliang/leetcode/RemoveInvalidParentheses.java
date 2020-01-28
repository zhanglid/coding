package com.zhangliang.leetcode;
/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all 
possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:

Input: ")("
Output: [""]
*/

import java.util.*;

public class RemoveInvalidParentheses {
    private int getRmCount(String s) {
        int count = 0;
        int state = 0;
        for (char x : s.toCharArray()) {
            if (x == '(') {
                state++;
            } else if (x == ')') {
                state--;
            } else {
                continue;
            }
            if (state < 0) {
                state++;
                count++;
            }
        }
        return count + state;
    }

    private void dfs(StringBuilder sb, int index, String s, int count, int rmCount, Set<String> result) {
        if (index == s.length()) {
            if (rmCount == 0 && count == 0) {
                result.add(sb.toString());
            }
            return;
        }
        char x = s.charAt(index);
        if (x == '(') {
            if (rmCount > 0) {
                dfs(sb, index + 1, s, count, rmCount - 1, result);
            }
            sb.append(x);
            dfs(sb, index + 1, s, count + 1, rmCount, result);
            sb.deleteCharAt(sb.length() - 1);
        } else if (x == ')') {
            if (rmCount > 0) {
                dfs(sb, index + 1, s, count, rmCount - 1, result);
            }
            if (count > 0) {
                sb.append(x);
                dfs(sb, index + 1, s, count - 1, rmCount, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(x);
            dfs(sb, index + 1, s, count, rmCount, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int rmCount = getRmCount(s);
        Set<String> ans = new HashSet<>();
        dfs(new StringBuilder(), 0, s, 0, rmCount, ans);
        return new ArrayList<String>(ans);
    }
}

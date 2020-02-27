package com.zhangliang.snapchat;
/*
Given an expression, "1+2*3-4"
Return all the possible calculation results by adding parentheses?
"(1+2)*3-4" -> 5, "1+2*(3-4)" -> -1, "1+2*3-4" -> 3, ..., "1+((2*3)-4)",
return [5, -1, 3, ..]
All operators are in [-, +, *]
All expression are valid
*/

import java.util.*;

/**
 * "1+2*3-4"
 * 
 * "(1+2)*3-4" "1+(2*3)-4" "1+2*(3-4)" "(1+2*3)-4" "1+(2*3-4)"
 * 
 * Assumption: All ops => [-, +, *], input does not have parentheses
 * 
 * "1+2+3-(5-4)"
 * 
 * Approach: DFS search
 * 
 */
public class AllPossibleCalculationResult {
    private int calc(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        }
        return a * b;
    }

    private Set<Integer> dfs(List<Integer> values, int vi, int vj, List<Character> ops, int oi, int oj) {
        Set<Integer> result = new HashSet<>();
        if (vi == vj) {
            result.add(values.get(vi));
            return result;
        }
        for (int i = 0; vi + i < vj; i++) {
            Set<Integer> left = dfs(values, vi, vi + i, ops, oi, oi + i - 1);
            Set<Integer> right = dfs(values, vi + i + 1, vj, ops, oi + i + 1, oj);
            for (Integer a : left) {
                for (Integer b : right) {
                    result.add(calc(a, b, ops.get(oi + i)));
                }
            }
        }
        return result;
    }

    public List<Integer> getAllResults(String expr) {
        String[] nums = expr.split("[\\*+-]");
        String[] ops = expr.split("\\d+");
        List<Integer> numList = new ArrayList<>();
        for (String num : nums) {
            numList.add(Integer.parseInt(num));
        }
        List<Character> opList = new ArrayList<>();
        for (String op : ops) {
            if (op.length() == 1) {
                opList.add(op.charAt(0));
            }
        }
        return new ArrayList<>(dfs(numList, 0, numList.size() - 1, opList, 0, opList.size() - 1));
    }
}

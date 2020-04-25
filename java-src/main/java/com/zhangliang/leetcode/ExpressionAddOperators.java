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

    private static final String[] OPERATORS = { "*", "+", "-" };

    private boolean isOperator(String s) {
        for (String op : OPERATORS) {
            if (op.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverflow(String s) {
        String maxIntStr = Integer.toString(Integer.MAX_VALUE);
        return !(s.length() < maxIntStr.length() || s.length() == maxIntStr.length() && s.compareTo(maxIntStr) <= 0);
    }

    private int eval(List<String> expression) {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i).equals("*")) {
                values.set(values.size() - 1, values.get(values.size() - 1) * Integer.parseInt(expression.get(i + 1)));
                i++;
            } else if (expression.get(i).equals("-")) {
                values.add(-Integer.parseInt(expression.get(i + 1)));
                i++;
            } else if (!expression.get(i).equals("+")) {
                values.add(Integer.parseInt(expression.get(i)));
            }
        }
        int result = 0;
        for (Integer value : values) {
            result += value;
        }
        return result;
    }

    private void generateHelper(String num, int index, List<String> expression, List<String> result, int target) {
        if (index >= num.length()) {
            if (eval(expression) == target) {
                result.add(String.join("", expression));
            }
            return;
        }
        String part = num.substring(index, index + 1);
        // Combine the previous number
        if (!expression.isEmpty()) {
            String last = expression.get(expression.size() - 1);
            if (!isOperator(last) && Integer.parseInt(last) != 0) {
                expression.set(expression.size() - 1, last + num.charAt(index));
                if (!isOverflow(expression.get(expression.size() - 1))) {
                    generateHelper(num, index + 1, expression, result, target);
                }
                expression.set(expression.size() - 1, last);
            }
        }

        for (String op : expression.isEmpty() ? new String[] { null } : OPERATORS) {
            if (op != null) {
                expression.add(op);
            }
            expression.add(part);
            generateHelper(num, index + 1, expression, result, target);
            expression.remove(expression.size() - 1);
            if (op != null) {
                expression.remove(expression.size() - 1);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        generateHelper(num, 0, new ArrayList<>(), result, target);
        return result;
    }
}

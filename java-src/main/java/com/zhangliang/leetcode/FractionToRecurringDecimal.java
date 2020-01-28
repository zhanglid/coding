package com.zhangliang.leetcode;
/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in 
string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"
*/

import java.util.*;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numeratorInt, int denominatorInt) {
        long numerator = (long) numeratorInt;
        long denominator = (long) denominatorInt;
        int sign = 1;
        if (numerator < 0) {
            numerator = -numerator;
            sign = -sign;
        }
        if (denominator < 0) {
            denominator = -denominator;
            sign = -sign;
        }
        long intVal = numerator / denominator;
        numerator -= intVal * denominator;
        Map<Long, Integer> indexMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (numerator > 0 && !indexMap.containsKey(numerator)) {
            long val = numerator * 10 / denominator;
            indexMap.put((long) numerator, sb.length());
            sb.append(val);
            numerator = 10 * numerator - val * denominator;
        }
        if (numerator == 0) {
            if (sb.length() < 1) {
                if (intVal == 0) {
                    return "0";
                }
                return (sign == 1 ? "" : "-") + intVal;
            }
            return (sign == 1 ? "" : "-") + intVal + "." + sb.toString();
        }
        sb.insert(indexMap.get(numerator), "(");
        return (sign == 1 ? "" : "-") + intVal + "." + sb.toString() + ")";
    }
}

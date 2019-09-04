package com.zhangliang.leetcode;
/*
Given a non-negative integer num represented as a string, remove k digits from the number so that 
the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain 
leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/

import java.util.*;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Set<Integer> digitIndexToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length() && k > 0; i++) {
            while (!stack.isEmpty() && num.charAt(stack.peek()) > num.charAt(i) && k > 0) {
                digitIndexToRemove.add(stack.pop());
                k--;
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (!digitIndexToRemove.contains(i)) {
                sb.append(num.charAt(i));
            }
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        String result = sb.toString().substring(0, Math.max(0, sb.length() - k));
        return result.length() < 1 ? "0" : result;
    }
}

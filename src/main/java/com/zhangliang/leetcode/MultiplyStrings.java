package com.zhangliang.leetcode;
/*
Given two non-negative integers num1 and num2 represented as strings, 
return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer 
directly.
*/

import java.util.*;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int targetIndex = (num1.length() - 1 - i) + (num2.length() - 1 - j);
                digits[targetIndex] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int step = 0;
        // Process step
        for (int i = 0; i < digits.length; i++) {
            int total = digits[i] + step;
            digits[i] = total % 10;
            step = total / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (sb.length() > 0 || digits[i] != 0) {
                sb.append(digits[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

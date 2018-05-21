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

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() < 1 || num2.length() < 1) {
            return "";
        }

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        List<Integer> reversedAns = new ArrayList<>();
        reversedAns.add(0);
        int offset = 0;
        for (int i = chars2.length - 1; i >= 0; i--) {
            int digit = chars2[i] - '0';
            if (digit != 0) {
                for (int j = 0; j < chars1.length; j++) {
                    int digit2 = chars1[chars1.length - j - 1] - '0';
                    int index = j + offset;
                    while (index >= reversedAns.size()) {
                        reversedAns.add(0);
                    }
                    reversedAns.set(index, reversedAns.get(index) + digit * digit2);
                }

                int step = 0;
                for (int j = 0; j < reversedAns.size(); j++) {
                    int cur = reversedAns.get(j) + step;
                    step = cur / 10;
                    cur %= 10;
                    reversedAns.set(j, cur);
                }

                if (step != 0) {
                    reversedAns.add(step);
                }
            }
            offset++;
        }

        StringBuilder sb = new StringBuilder();
        int head = reversedAns.size() - 1;
        while (head >= 0 && reversedAns.get(head) == 0) {
            head--;
        }

        while (head >= 0) {
            sb.append(reversedAns.get(head--));
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}

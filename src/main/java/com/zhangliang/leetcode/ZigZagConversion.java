package com.zhangliang.leetcode;

import java.lang.StringBuilder;
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int offset = i % (numRows - 1);
            int loop = i / (numRows - 1);
            int index = (loop % 2 == 0 ? offset : numRows - 1 - offset);
            sbs[index].append(chars[i]);
        }

        StringBuilder ansBuilder = new StringBuilder();
        for (StringBuilder sb : sbs) {
            ansBuilder.append(sb);
        }

        return ansBuilder.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion s = new ZigZagConversion();
        System.out.println(s.convert("PAYPALISHIRING", 4));
    }
}
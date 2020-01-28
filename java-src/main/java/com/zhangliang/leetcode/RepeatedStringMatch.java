package com.zhangliang.leetcode;
/*
Given two strings A and B, find the minimum number of times A has to be repeated 
such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring 
of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
*/

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        String repeatedA = A;
        int times = 1;
        while (repeatedA.length() < B.length()) {
            times++;
            repeatedA += A;
        }
        if (repeatedA.indexOf(B) >= 0) {
            return times;
        }
        repeatedA += A;
        times++;
        if (repeatedA.indexOf(B) >= 0) {
            return times;
        }
        return -1;
    }
}

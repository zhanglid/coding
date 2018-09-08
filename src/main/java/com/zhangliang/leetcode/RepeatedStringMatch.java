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
        if (A == null || B == null) {
            return -1;
        }

        if (B.isEmpty()) {
            return 0;
        }

        if (A.indexOf(B) >= 0) {
            return 1;
        } else if ((A + A).indexOf(B) >= 0) {
            return 2;
        }

        if (B.length() < A.length()) {
            return -1;
        }

        int start = B.indexOf(A);

        if (start < 0) {
            return -1;
        }

        String left = B.substring(0, start);
        int num = 1;
        start += A.length();
        while (start + A.length() <= B.length() && B.substring(start, start + A.length()).equals(A)) {
            num++;
            start += A.length();
        }
        String right = B.substring(start);

        if (left.length() >= A.length() || !A.substring(A.length() - left.length(), A.length()).equals(left)) {
            return -1;
        }

        if (right.length() >= A.length() || !A.substring(0, right.length()).equals(right)) {
            return -1;
        }

        return num + (left.isEmpty() ? 0 : 1) + (right.isEmpty() ? 0 : 1);
    }
}

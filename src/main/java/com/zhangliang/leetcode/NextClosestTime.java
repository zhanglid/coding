package com.zhangliang.leetcode;
/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no 
limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are 
all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 
19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time 
is next day's time since it is smaller than the input time numerically.

*/

public class NextClosestTime {
    private String buildAns(int[] digits) {
        StringBuilder sb = new StringBuilder();
        sb.append(digits[0]);
        sb.append(digits[1]);
        sb.append(':');
        sb.append(digits[2]);
        sb.append(digits[3]);

        return sb.toString();
    }

    public String nextClosestTime(String time) {
        int[] digits = new int[4];
        digits[0] = time.charAt(0) - '0';
        digits[1] = time.charAt(1) - '0';
        digits[2] = time.charAt(3) - '0';
        digits[3] = time.charAt(4) - '0';

        int min = digits[0];
        // check last
        int last = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > digits[3] && (last == -1 || digits[i] < last)) {
                last = digits[i];
            }
            min = Math.min(digits[i], min);
        }

        if (last != -1) {
            digits[3] = last;
            return buildAns(digits);
        }

        // ten minutes
        int second = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > digits[2] && digits[i] < 6 && (second == -1 || digits[i] < second)) {
                second = digits[i];
            }
        }

        if (second >= 0) {
            digits[3] = min;
            digits[2] = second;
            return buildAns(digits);
        }

        // hour
        int hourSecond = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > digits[1] && (digits[i] < 4 && digits[0] == 2 || digits[0] < 2) && (hourSecond == -1 || digits[i] < hourSecond)) {
                hourSecond = digits[i];
            }
        }

        if (hourSecond >= 0) {
            digits[1] = hourSecond;
            digits[2] = min;
            digits[3] = min;

            return buildAns(digits);
        }

        // hour
        int hour = -1;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > digits[0] && digits[i] <= 2) {
                hour = digits[i];
            }
        }

        if (hour > 0) {
            digits[0] = hour;
            digits[1] = min;
            digits[2] = min;
            digits[3] = min;

            return buildAns(digits);
        }

        digits[0] = min;
        digits[1] = min;
        digits[2] = min;
        digits[3] = min;

        return buildAns(digits);
    }
}

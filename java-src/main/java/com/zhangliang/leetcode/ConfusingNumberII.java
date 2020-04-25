package com.zhangliang.leetcode;
/*
We can rotate digits by 180 degrees to form new digits. 
When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 
respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become 
invalid.

A confusing number is a number that when rotated 180 degrees becomes a 
different number with each digit valid.(Note that the rotated number can 
be greater than the original number.)

Given a positive integer N, return the number of confusing numbers 
between 1 and N inclusive.

Example 1:

Input: 20
Output: 6
Explanation: 
The confusing numbers are [6,9,10,16,18,19].
6 converts to 9.
9 converts to 6.
10 converts to 01 which is just 1.
16 converts to 91.
18 converts to 81.
19 converts to 61.

Example 2:

Input: 100
Output: 19
Explanation: 
The confusing numbers are 
[6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 

Note:

1 <= N <= 10^9

len = 1   6, 9
len = 2   10, 16, 18, 19, 
          61, 66, 68, 69, 
          81, 86, 89,
          91, 96, 98, 99
*/

public class ConfusingNumberII {
    private static int[] VALID_DIGITS = { 0, 1, 6, 8, 9 };
    private static int[] ROTATE_DIGIT_MAP = { 0, 1, 2, 3, 4, 5, 9, 7, 8, 6 };

    private int rotate(int num) {
        int result = 0;
        while (num != 0) {
            result = 10 * result + ROTATE_DIGIT_MAP[num % 10];
            num /= 10;
        }
        return result;
    }

    private void dfs(int num, int N, int[] result) {
        if (num > N) {
            return;
        }
        if (rotate(num) != num) {
            result[0]++;
        }
        if (num == 0) {
            return;
        }
        for (int digit : VALID_DIGITS) {
            if ((num * 10 + digit) / 10 == num) {
                dfs(num * 10 + digit, N, result);
            }
        }
    }

    public int confusingNumberII(int N) {
        int[] result = new int[1];
        for (int num : VALID_DIGITS) {
            dfs(num, N, result);
        }
        return result[0];
    }
}

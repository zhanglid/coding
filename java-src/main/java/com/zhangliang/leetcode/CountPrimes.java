package com.zhangliang.leetcode;
/*
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 1) {
            return 0;
        }

        int count = 0;
        boolean[] chosen = new boolean[n];
        for (int i = 2; i < chosen.length; i++) {
            if (chosen[i]) {
                continue;
            }
            count++;
            for (int j = 1; j * i < n; j++) {
                chosen[i * j] = true;
            }
        }

        return count;
    }
}

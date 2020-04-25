package com.zhangliang.leetcode;
/*
Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. 
The answer may be very large, return it after mod 10^9 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8 

Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times. 
Note: The value of n won't exceed 100,000.
*/

public class StudentAttendanceRecordII {
    private static int MOD = 1_000_000_000 + 7;

    public int checkRecord(int n) {
        if (n < 1) {
            return 0;
        }
        int[] nonAnonL = new int[2];
        nonAnonL[0] = 1;
        int[] nonAL = new int[2];
        nonAL[0] = 1;
        int[] nonA2L = new int[2];
        nonA2L[0] = 0;

        int[] aNonL = new int[2];
        aNonL[0] = 1;
        int[] aL = new int[2];
        aL[0] = 0;
        int[] a2L = new int[2];
        a2L[0] = 0;

        for (int i = 1; i < n; i++) {
            nonAnonL[i % 2] = ((nonAnonL[(i - 1) % 2] + nonAL[(i - 1) % 2]) % MOD + nonA2L[(i - 1) % 2]) % MOD;
            nonAL[i % 2] = nonAnonL[(i - 1) % 2];
            nonA2L[i % 2] = nonAL[(i - 1) % 2];

            aNonL[i % 2] = (((nonAnonL[(i - 1) % 2] + nonAL[(i - 1) % 2]) % MOD
                    + (nonA2L[(i - 1) % 2] + aNonL[(i - 1) % 2]) % MOD) % MOD
                    + (aL[(i - 1) % 2] + a2L[(i - 1) % 2]) % MOD) % MOD;
            aL[i % 2] = aNonL[(i - 1) % 2];
            a2L[i % 2] = aL[(i - 1) % 2];
        }

        return (((nonAnonL[(n - 1) % 2] + nonAL[(n - 1) % 2]) % MOD + (nonA2L[(n - 1) % 2] + aNonL[(n - 1) % 2]) % MOD)
                % MOD + (aL[(n - 1) % 2] + a2L[(n - 1) % 2]) % MOD) % MOD;
    }
}

package com.zhangliang.leetcode;
/*
In a row of dominoes, A[i] and B[i] represent the top and bottom 
halves of the i-th domino.  
(A domino is a tile with two numbers from 1 to 6 - one on each 
half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in 
A are the same, or all the values in B are the same.

If it cannot be done, return -1.
 

Example 1:

Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: 
before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value 
in the top row equal to 2, as indicated by the second figure.

Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one 
row of values equal.
 

Note:

1 <= A[i], B[i] <= 6
2 <= A.length == B.length <= 20000
*/

public class MinimumDominoRotationsForEqualRow {
    private int helper(int[] A, int[] B) {
        int value = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[0]) {
                continue;
            }
            if (B[i] != A[0]) {
                value = -1;
                break;
            }
            value++;
        }
        return value;
    }

    public int minDominoRotations(int[] A, int[] B) {
        int aa = helper(A, B);
        int bb = helper(B, A);
        int t = A[0];
        A[0] = B[0];
        B[0] = t;
        int ab = helper(A, B);
        if (ab != -1) {
            ab += 1;
        }
        int ba = helper(B, A);
        if (ba != -1) {
            ba += 1;
        }

        int ans = aa;
        if (bb >= 0) {
            ans = ans == -1 ? bb : Math.min(ans, bb);
        }
        if (ab >= 0) {
            ans = ans == -1 ? ab : Math.min(ans, ab);
        }
        if (ba >= 0) {
            ans = ans == -1 ? ba : Math.min(ans, ba);
        }
        return ans;
    }
}

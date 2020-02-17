package com.zhangliang.leetcode;
/*
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.

 

Example 1:

Input: A = [1], K = 1
Output: 1
Example 2:

Input: A = [1,2], K = 4
Output: -1
Example 3:

Input: A = [2,-1,2], K = 3
Output: 3
 

Note:

1 <= A.length <= 50000
-10 ^ 5 <= A[i] <= 10 ^ 5
1 <= K <= 10 ^ 9
*/

import java.util.*;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }

        int len = -1;
        Deque<Integer> monoQ = new LinkedList<>();
        monoQ.add(0);
        for (int i = 0; i < A.length; i++) {
            int sum = sums[i + 1];
            while (!monoQ.isEmpty() && sum <= sums[monoQ.peekLast()]) {
                monoQ.pollLast();
            }
            while (!monoQ.isEmpty() && sum - sums[monoQ.peekFirst()] >= K) {
                int currentLen = i - monoQ.peekFirst() + 1;
                if (len == -1 || len >= currentLen) {
                    len = currentLen;
                }
                monoQ.pollFirst();
            }
            monoQ.add(i + 1);
        }

        return len;
    }
}

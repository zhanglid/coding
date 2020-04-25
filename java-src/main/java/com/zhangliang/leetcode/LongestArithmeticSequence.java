package com.zhangliang.leetcode;
/*
Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, 
and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).

Example 1:
Input: [3,6,9,12]
Output: 4
Explanation: 
The whole array is an arithmetic sequence with steps of length = 3.

Example 2:
Input: [9,4,7,2,10]
Output: 3
Explanation: 
The longest arithmetic subsequence is [4,7,10].

Example 3:
Input: [20,1,15,3,10,5,8]
Output: 4
Explanation: 
The longest arithmetic subsequence is [20,15,10,5].

Note:
2 <= A.length <= 2000
0 <= A[i] <= 10000
*/

import java.util.*;

public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            dp.add(new HashMap<>());
            for (int j = i - 1; j >= 0; j--) {
                int diff = a - A[j];
                int size = 2;
                if (dp.get(j).containsKey(diff)) {
                    size = Math.max(size, dp.get(j).get(diff) + 1);
                }
                ans = Math.max(ans, size);
                dp.get(i).put(diff, Math.max(size, dp.get(i).getOrDefault(diff, 0)));
            }
        }
        return ans;
    }
}

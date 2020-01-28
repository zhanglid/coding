package com.zhangliang.leetcode;
/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] p = new int[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * i;
        }

        return helper(n, k, p);
    }

    private String helper(int n, int k, int[] p) {
        StringBuilder sb = new StringBuilder();
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                sb.append(i + 1);
            }

            return sb.toString();
        }

        int cur = (k - 1) / p[n - 1] + 1;
        String prev = helper(n - 1, (k - 1) % p[n - 1] + 1, p);
        sb.append(cur);
        for (char c : prev.toCharArray()) {
            if (c - '0' >= cur) {
                sb.append((char) ((int) c + 1));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

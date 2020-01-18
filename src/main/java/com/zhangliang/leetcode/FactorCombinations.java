package com.zhangliang.leetcode;
/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Example 1:
Input: 1
Output: []

Example 2:
Input: 37
Output:[]

Example 3:
Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

Example 4:
Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

import java.util.*;

public class FactorCombinations {
    private Map<Integer, List<List<Integer>>> cache = new HashMap<>();

    public List<List<Integer>> getFactors(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int base = 2; base * base <= n; base++) {
            if (n % base == 0) {
                result.add(Arrays.asList(base, n / base));
                List<List<Integer>> rest = getFactors(n / base);
                for (List<Integer> part : rest) {
                    // # Attention: Only include rest factors that are larger than base to avoid
                    // duplication.
                    if (part.isEmpty() || part.get(0) < base) {
                        continue;
                    }
                    List<Integer> combined = new ArrayList<>();
                    combined.add(base);
                    combined.addAll(part);
                    result.add(combined);
                }
            }
        }

        cache.put(n, result);
        return result;
    }
}

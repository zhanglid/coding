package com.zhangliang.leetcode;
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that 
no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

import java.util.HashSet;
import java.util.Set;

public class NQueensII {
    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        return helper(new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), 0, n);
    }

    private int helper(Set<Integer> rowSet, Set<Integer> diagSet, Set<Integer> reversedDiagSet, int cur, int n) {
        if (cur == n) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!rowSet.contains(i) && !diagSet.contains(i + cur) && !reversedDiagSet.contains(cur - i)) {
                rowSet.add(i);
                diagSet.add(i + cur);
                reversedDiagSet.add(cur - i);
                ans += helper(rowSet, diagSet, reversedDiagSet, cur + 1, n);
                rowSet.remove(i);
                diagSet.remove(i + cur);
                reversedDiagSet.remove(cur - i);
            }
        }

        return ans;
    }
}

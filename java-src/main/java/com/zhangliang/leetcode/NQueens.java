package com.zhangliang.leetcode;
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two 
queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' 
and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }

        helper(new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), new ArrayList<Integer>(), ans,
                n);

        return ans;
    }

    private List<String> generateBoard(List<Integer> posList) {
        int n = posList.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }

        List<String> ans = new ArrayList<>();
        for (int pos : posList) {
            sb.setCharAt(pos, 'Q');
            ans.add(sb.toString());
            sb.setCharAt(pos, '.');
        }

        return ans;
    }

    private void helper(Set<Integer> col, Set<Integer> diag, Set<Integer> reversedDiag, List<Integer> posList,
            List<List<String>> ans, int n) {
        if (posList.size() == n) {
            ans.add(generateBoard(posList));
            return;
        }

        int j = posList.size() - 1;
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !diag.contains(i + j) && !reversedDiag.contains(i - j)) {
                col.add(i);
                diag.add(i + j);
                reversedDiag.add(i - j);
                posList.add(i);
                helper(col, diag, reversedDiag, posList, ans, n);
                col.remove(i);
                diag.remove(i + j);
                reversedDiag.remove(i - j);
                posList.remove(posList.size() - 1);
            }
        }
    }
}

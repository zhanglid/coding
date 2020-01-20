package com.zhangliang.leetcode;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be 
used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

import java.util.*;

public class WordSearch {
    static int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private int hash(int i, int j, char[][] board) {
        return i * board[0].length + j;
    }

    private boolean dfs(char[][] board, String target, int index, int i, int j, Set<Integer> visited) {
        int hashCode = hash(i, j, board);
        if (visited.contains(hashCode)) {
            return false;
        }
        if (board[i][j] != target.charAt(index)) {
            return false;
        }
        if (index == target.length() - 1) {
            return true;
        }
        visited.add(hashCode);
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) {
                continue;
            }
            if (dfs(board, target, index + 1, ni, nj, visited)) {
                return true;
            }
        }
        visited.remove(hashCode);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }
}
